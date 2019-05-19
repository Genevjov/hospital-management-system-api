package ua.dlubovskyi.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.PatientDoctorsEntity;
import ua.dlubovskyi.hms.repository.PatientDoctorsRepository;

@Service
public class PatientDoctorsService {

    private final PatientDoctorsRepository patientDoctorsRepository;

    @Autowired
    public PatientDoctorsService(PatientDoctorsRepository patientDoctorsRepository) {
        this.patientDoctorsRepository = patientDoctorsRepository;
    }

    public void save(PatientDoctorsEntity patientDoctorsEntity) {
        patientDoctorsRepository.save(patientDoctorsEntity);
    }
}
