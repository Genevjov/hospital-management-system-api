package ua.dlubovskyi.hms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.entity.user.UserEntity;
import ua.dlubovskyi.hms.service.NurseService;

import java.util.List;

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
    private List<UserEntity> getAllNurses() {
        return nurseService.select();
    }
}
