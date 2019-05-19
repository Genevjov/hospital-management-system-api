package ua.dlubovskyi.hms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.entity.NurseEntity;
import ua.dlubovskyi.hms.service.NurseService;

/**
 * NurseEntity Rest API
 */
@RestController()
public class NurseRest {

    private NurseService nurseService;

    public NurseRest(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping("/nurses")
    private ResponseEntity<NurseEntity> getAllNurses(@RequestHeader("Auth") String authToken) {
        return null;
    }
}
