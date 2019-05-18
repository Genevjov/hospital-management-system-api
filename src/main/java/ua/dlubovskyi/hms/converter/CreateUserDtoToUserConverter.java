package ua.dlubovskyi.hms.converter;

import org.springframework.core.convert.converter.Converter;
import ua.dlubovskyi.hms.dto.create.CreateUserDto;
import ua.dlubovskyi.hms.entity.User;

public class CreateUserDtoToUserConverter implements Converter<CreateUserDto, User> {

    @Override
    public User convert(CreateUserDto source) {
        User user = new User();
        user.setFirstName(source.getFirstName());
        user.setSecondName(source.getSecondName());
        user.setHospitalId(source.getHospitalId());
        user.setDepartmentId(source.getDepartmentId());
        user.setCountryCode(source.getCountryCode());
        return user;
    }
}
