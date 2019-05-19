package ua.dlubovskyi.hms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dlubovskyi.hms.entity.PatientDoctorsEntity;

@Repository
public interface PatientDoctorsRepository extends CrudRepository<PatientDoctorsEntity, String> {
}
