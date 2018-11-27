package ua.dlubovskyi.hms.service;

import org.springframework.stereotype.Component;
import ua.dlubovskyi.hms.bean.User;

import java.util.List;

@Component
public interface NurseService {

    List<User> select();


}
