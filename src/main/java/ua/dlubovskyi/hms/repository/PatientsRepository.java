package ua.dlubovskyi.hms.repository;

import org.springframework.data.repository.CrudRepository;
import ua.dlubovskyi.hms.entity.PatientEntity;

public interface PatientsRepository extends CrudRepository<PatientEntity, String> {
}
