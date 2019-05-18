package ua.dlubovskyi.hms.service.impl;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.Hospital;
import ua.dlubovskyi.hms.repository.HospitalRepository;

import javax.persistence.EntityManager;

@Service
public class HospitalService {

    private HospitalRepository hospitalRepository;
    private EntityManager entityManager;

    public HospitalService(HospitalRepository hospitalRepository, EntityManager entityManager) {
        this.hospitalRepository = hospitalRepository;
        this.entityManager = entityManager;
    }

    public void addHospital(Hospital newHospital) {
        hospitalRepository.save(newHospital);
    }
}
