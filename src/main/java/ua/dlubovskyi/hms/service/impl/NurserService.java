package ua.dlubovskyi.hms.service.impl;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.bean.User;
import ua.dlubovskyi.hms.service.NurseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurserService implements NurseService {
    @Override
    public List<User> select() {
        List<User> nurses= new ArrayList<>();
        nurses.add(new User("111"," LOL"));
        return nurses;
    }
}
