package ua.dlubovskyi.hms.controller;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.dto.create.CreateDoctorDto;
import ua.dlubovskyi.hms.entity.DoctorEntity;
import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.DoctorService;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.UserService;
import ua.dlubovskyi.hms.util.SecurityUtils;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static ua.dlubovskyi.hms.entity.Role.SERVICE_ADMIN;

/**
 * DoctorEntity Rest API
 */
@RestController
public class DoctorRest {

    private SecurityUtils securityUtils;
    private ConversionService conversionService;
    private UserService userService;
    private TokenService tokenService;
    private DoctorService doctorService;

    public DoctorRest(SecurityUtils securityUtils, ConversionService conversionService, UserService userService, TokenService tokenService, DoctorService doctorService) {
        this.securityUtils = securityUtils;
        this.conversionService = conversionService;
        this.userService = userService;
        this.tokenService = tokenService;
        this.doctorService = doctorService;
    }

    @PutMapping("/doctor")
    public ResponseEntity<DoctorEntity> createDoctor(@RequestHeader("Auth") String authToken,
                                                     @RequestBody CreateDoctorDto createDoctorDto) {
        if (securityUtils.isActionGrated(authToken, SERVICE_ADMIN, Role.HOSPITAL_ADMIN)) {
            User newUser = conversionService.convert(createDoctorDto.getCreateUserDto(), User.class);
            DoctorEntity doctorEntity = conversionService.convert(createDoctorDto, DoctorEntity.class);
            String userId = tokenService.getUserIdByToken(authToken);
            User user = userService.findById(userId);
            if (user.getHospitalId().equals(createDoctorDto.getCreateUserDto().getHospitalId()) ||
                    user.getProfileType().equals(SERVICE_ADMIN.name())) {
                userService.createUser(newUser);
                return new ResponseEntity<>(doctorService.createDoctor(doctorEntity), CREATED);
            }
        }
        return new ResponseEntity<>(FORBIDDEN);
    }
}