package ua.dlubovskyi.hms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.PatientService;

import java.util.List;

@RestController
public class PatientRest {

    private PatientService patientService;

    public PatientRest(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    private List<User> getAllPatient() {
        return null;
    }
}
