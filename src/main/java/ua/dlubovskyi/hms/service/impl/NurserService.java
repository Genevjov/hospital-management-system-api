package ua.dlubovskyi.hms.service.impl;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.user.UserEntity;
import ua.dlubovskyi.hms.service.NurseService;

import java.util.List;

@Service
public class NurserService implements NurseService {
    @Override
    public List<UserEntity> select() {
        return null;
    }
}
