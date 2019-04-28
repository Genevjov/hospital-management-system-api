package ua.dlubovskyi.hms.controller;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.dto.create.CreateHospitalDto;
import ua.dlubovskyi.hms.entity.Hospital;
import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.HospitalService;
import ua.dlubovskyi.hms.service.impl.UserService;
import ua.dlubovskyi.hms.util.RoleValidator;

import static java.util.Objects.nonNull;

@RestController
public class HospitalRest {

    private HospitalService hospitalService;
    private TokenService tokenService;
    private UserService userService;
    private ConversionService conversionService;


    public HospitalRest(HospitalService hospitalService, TokenService tokenService, UserService userService, ConversionService conversionService) {
        this.hospitalService = hospitalService;
        this.tokenService = tokenService;
        this.userService = userService;
        this.conversionService = conversionService;
    }

    @PutMapping("/hospitals")
    public ResponseEntity<Hospital> getAllHospitals(@RequestHeader("Auth") String authToken,
                                                    @RequestBody CreateHospitalDto createHospitalDto) {
        if (tokenService.isTokenValid(authToken)) {
            String userId = tokenService.getUserIdByToken(authToken);
            if (nonNull(userId)) {
                User user = userService.findById(userId);
                if (nonNull(user) && RoleValidator.isRoleEqual(user, Role.HOSPITAL_ADMIN)) {
                    Hospital newHospital = conversionService.convert(createHospitalDto, Hospital.class);
                    hospitalService.addHospital(newHospital);
                    tokenService.updateToken(userId);
                    return new ResponseEntity<>(newHospital, HttpStatus.CREATED);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
