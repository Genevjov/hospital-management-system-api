package ua.dlubovskyi.hms.util.strategy.profile.impl;

import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.impl.PatientDoctorsService;
import ua.dlubovskyi.hms.util.strategy.profile.Checker;

import static ua.dlubovskyi.hms.entity.Role.NURSE;
import static ua.dlubovskyi.hms.entity.Role.PATIENT;

public class DoctorChecker implements Checker {

    private final PatientDoctorsService patientDoctorsService;

    public DoctorChecker(PatientDoctorsService patientDoctorsService) {
        this.patientDoctorsService = patientDoctorsService;
    }

    @Override
    public boolean check(User profileOwner, User target) {
        return profileOwner.getHospitalId().equals(target.getHospitalId()) &&
                target.getProfileType().equals(PATIENT.name() ) ||
                (profileOwner.getProfileType().equals(Role.DOCTOR.name()) ||
                        profileOwner.getProfileType().equals(NURSE.name())
                                && profileOwner.getHospitalId().equals(target.getProfileType()));
    }
}
