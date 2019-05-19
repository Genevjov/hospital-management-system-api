package ua.dlubovskyi.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.NurseEntity;
import ua.dlubovskyi.hms.repository.NurseRepository;
import ua.dlubovskyi.hms.service.NurseService;

@Service
public class NurserService implements NurseService {

    private final NurseRepository nurseRepository;


    @Autowired
    public NurserService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public void addNewNurse(NurseEntity nurseEntity) {
        nurseRepository.save(nurseEntity);
    }
}
