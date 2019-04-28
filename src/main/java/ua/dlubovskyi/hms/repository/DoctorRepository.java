package ua.dlubovskyi.hms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dlubovskyi.hms.entity.DoctorEntity;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorEntity, String> {
}
