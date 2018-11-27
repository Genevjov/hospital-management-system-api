package ua.dlubovskyi.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.service.DoctorService;

/**
 * DoctorEntity Rest API
 */
@RestController
public class DoctorRest {

    @Autowired
    private DoctorService doctorService;


    /**
     * Rest for get list of doctors
     */
    @GetMapping("/doctors")
    public void getAllDoctors() {
        System.out.println("lol");
    }
}