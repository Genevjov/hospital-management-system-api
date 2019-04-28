package ua.dlubovskyi.hms.converter;

import org.springframework.core.convert.converter.Converter;
import ua.dlubovskyi.hms.entity.NurseEntity;
import ua.dlubovskyi.hms.dto.users.NurseDto;

import java.util.UUID;

public class NurseDtoToNurserEntityConverter implements Converter<NurseDto, NurseEntity> {

    @Override
    public NurseEntity convert(NurseDto source) {
        String userId = UUID.randomUUID().toString();
        NurseEntity convertedEntity = new NurseEntity();

        return null;
    }
}
