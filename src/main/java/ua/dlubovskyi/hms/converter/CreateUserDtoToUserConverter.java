package ua.dlubovskyi.hms.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.dlubovskyi.hms.dto.create.CreateUserDto;
import ua.dlubovskyi.hms.entity.User;

import java.util.UUID;

@Component
public class CreateUserDtoToUserConverter implements Converter<CreateUserDto, User> {

    @Override
    public User convert(CreateUserDto source) {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setFirstName(source.getFirstName());
        user.setSecondName(source.getSecondName());
        user.setHospitalId(source.getHospitalId());
        user.setDepartmentId(source.getDepartmentId());
        user.setCountryCode(source.getCountryCode());
        user.setProfileType(source.getUserRole().name());
        return user;
    }
}
