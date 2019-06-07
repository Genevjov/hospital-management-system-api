package ua.dlubovskyi.hms.service.impl;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.Hospital;
import ua.dlubovskyi.hms.repository.HospitalRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public List<Hospital> getAll() {
        return StreamSupport
                .stream(hospitalRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Hospital findById(String id) {
        return hospitalRepository.findById(id).orElse(null);
    }
}
