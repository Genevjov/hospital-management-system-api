package ua.dlubovskyi.hms.controller;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dlubovskyi.hms.dto.create.CreateHospitalDto;
import ua.dlubovskyi.hms.entity.Hospital;
import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.HospitalService;
import ua.dlubovskyi.hms.service.impl.UserService;
import ua.dlubovskyi.hms.util.SecurityUtils;

import java.util.Collections;
import java.util.List;

import static ua.dlubovskyi.hms.entity.Role.SERVICE_ADMIN;

@RestController
public class HospitalRest {

    private HospitalService hospitalService;
    private ConversionService conversionService;
    private SecurityUtils securityUtils;
    private TokenService tokenService;
    private UserService userService;

    public HospitalRest(HospitalService hospitalService, ConversionService conversionService, SecurityUtils securityUtils, TokenService tokenService) {
        this.hospitalService = hospitalService;
        this.conversionService = conversionService;
        this.securityUtils = securityUtils;
        this.tokenService = tokenService;

    }

    @PutMapping("/hospitals")
    public ResponseEntity<Hospital> newHospital(@RequestHeader("Auth") String authToken,
                                                @RequestBody CreateHospitalDto createHospitalDto) {
        if (securityUtils.isActionGrated(authToken, SERVICE_ADMIN)) {
            Hospital newHospital = conversionService.convert(createHospitalDto, Hospital.class);
            hospitalService.addHospital(newHospital);
            tokenService.updateToken(tokenService.getUserIdByToken(authToken));
            return new ResponseEntity<>(newHospital, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/hospitals")
    public ResponseEntity<List<Hospital>> getAll(@RequestHeader("Auth") String authToken) {
        if (securityUtils.isActionGrated(authToken, SERVICE_ADMIN)) {
            tokenService.updateToken(tokenService.getUserIdByToken(authToken));
            return new ResponseEntity<>(hospitalService.getAll(), HttpStatus.CREATED);
        } else if (securityUtils.isActionGrated(authToken, Role.values())) {
            User user = userService.findById(tokenService.getUserIdByToken(authToken));
            return new ResponseEntity<>(Collections.singletonList(hospitalService.findById(user.getHospitalId())), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
