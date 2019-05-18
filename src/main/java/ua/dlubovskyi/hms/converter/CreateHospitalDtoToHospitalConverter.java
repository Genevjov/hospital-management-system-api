package ua.dlubovskyi.hms.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.dlubovskyi.hms.dto.create.CreateHospitalDto;
import ua.dlubovskyi.hms.entity.Hospital;

import java.util.UUID;

@Component
public class CreateHospitalDtoToHospitalConverter implements Converter<CreateHospitalDto, Hospital> {

    @Override
    public Hospital convert(CreateHospitalDto source) {
        Hospital hospital = new Hospital();
        hospital.setHospitalAddress(source.getAddress());
        hospital.setHospitalId(UUID.randomUUID().toString());
        hospital.setHospitalName(source.getHospitalName());
        return hospital;
    }
}
