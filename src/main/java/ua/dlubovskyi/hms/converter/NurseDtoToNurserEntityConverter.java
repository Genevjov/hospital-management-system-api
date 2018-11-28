package ua.dlubovskyi.hms.converter;

import org.springframework.core.convert.converter.Converter;
import ua.dlubovskyi.hms.dto.CreateNurseDto;
import ua.dlubovskyi.hms.entity.user.nurse.NurseEntity;

import java.util.UUID;

public class NurseDtoToNurserEntityConverter implements Converter<CreateNurseDto, NurseEntity> {

    @Override
    public NurseEntity convert(CreateNurseDto source) {
        String userId = UUID.randomUUID().toString();
        NurseEntity convertedEntity = new NurseEntity();

        return null;
    }
}
