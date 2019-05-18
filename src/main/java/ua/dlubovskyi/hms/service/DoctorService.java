package ua.dlubovskyi.hms.service;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.DoctorEntity;

@Service
public interface DoctorService {

    public DoctorEntity createDoctor(DoctorEntity doctorEntity);
}
