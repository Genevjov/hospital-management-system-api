package ua.dlubovskyi.hms.service;

import ua.dlubovskyi.hms.entity.user.UserEntity;

import java.util.List;

public interface NurseService {

    List<UserEntity> select();
}
