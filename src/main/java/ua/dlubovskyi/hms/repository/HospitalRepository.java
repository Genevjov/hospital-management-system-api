package ua.dlubovskyi.hms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dlubovskyi.hms.entity.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, String> {
}
