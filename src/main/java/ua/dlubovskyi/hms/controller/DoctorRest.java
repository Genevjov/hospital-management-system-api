package ua.dlubovskyi.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.DoctorService;
import ua.dlubovskyi.hms.service.impl.UserService;

/**
 * DoctorEntity Rest API
 */
@RestController
public class DoctorRest {

    @Autowired
    UserService userService;
    @Autowired
    private DoctorService doctorService;

    /**
     * Rest for get list of doctors
     */
    @GetMapping("/doctors")
    public User getAllDoctors() {
        return userService.findById("e87ac28e-6ea5-4acc-aba2-ab046f2d485e");
    }
}