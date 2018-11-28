package ua.dlubovskyi.hms.service;

import org.springframework.stereotype.Component;
import ua.dlubovskyi.hms.entity.user.UserEntity;

import java.util.List;

@Component
public interface NurseService {

    List<UserEntity> select();


}
