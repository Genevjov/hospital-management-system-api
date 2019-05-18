package ua.dlubovskyi.hms.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.dlubovskyi.hms.dto.create.CreateDepartmentDto;
import ua.dlubovskyi.hms.entity.Department;

import java.util.UUID;

@Component
public class CreateDepartmentDtoToDepartmentConverter implements Converter<CreateDepartmentDto, Department> {

    @Override
    public Department convert(CreateDepartmentDto source) {
        Department department = new Department();
        department.setId(UUID.randomUUID().toString());
        department.setHospitalId(source.getHospitalId());
        department.setName(source.getDepartmentName());
        return department;
    }
}
