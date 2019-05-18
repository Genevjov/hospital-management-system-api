package ua.dlubovskyi.hms.service.impl;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.Department;
import ua.dlubovskyi.hms.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }
}
