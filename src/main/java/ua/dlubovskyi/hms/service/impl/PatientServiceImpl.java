package ua.dlubovskyi.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.PatientEntity;
import ua.dlubovskyi.hms.repository.PatientsRepository;
import ua.dlubovskyi.hms.service.PatientService;

import javax.transaction.Transactional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientsRepository patientsRepository;

    @Autowired
    public PatientServiceImpl(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    public void addNewPatient(PatientEntity patientEntity) {
        patientsRepository.save(patientEntity);
    }
}
