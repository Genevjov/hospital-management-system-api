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
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.HospitalService;
import ua.dlubovskyi.hms.util.SecurityUtils;

import static ua.dlubovskyi.hms.entity.Role.SERVICE_ADMIN;

@RestController
public class HospitalRest {

    private HospitalService hospitalService;
    private ConversionService conversionService;
    private SecurityUtils securityUtils;
    private TokenService tokenService;

    public HospitalRest(HospitalService hospitalService, ConversionService conversionService, SecurityUtils securityUtils, TokenService tokenService) {
        this.hospitalService = hospitalService;
        this.conversionService = conversionService;
        this.securityUtils = securityUtils;
        this.tokenService = tokenService;
    }

    @PutMapping("/hospitals")
    public ResponseEntity<Hospital> getAllHospitals(@RequestHeader("Auth") String authToken,
                                                    @RequestBody CreateHospitalDto createHospitalDto) {
        if (securityUtils.isActionGrated(authToken, SERVICE_ADMIN)) {
            Hospital newHospital = conversionService.convert(createHospitalDto, Hospital.class);
            hospitalService.addHospital(newHospital);
            tokenService.updateToken(tokenService.getUserIdByToken(authToken));
            return new ResponseEntity<>(newHospital, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
