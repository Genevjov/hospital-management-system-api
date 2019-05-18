package ua.dlubovskyi.hms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dlubovskyi.hms.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, String> {


}
