package ua.dlubovskyi.hms.service.impl;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.DoctorEntity;
import ua.dlubovskyi.hms.repository.DoctorRepository;
import ua.dlubovskyi.hms.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;


    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorEntity createDoctor(DoctorEntity doctorEntity) {
        return doctorRepository.save(doctorEntity);
    }
}
