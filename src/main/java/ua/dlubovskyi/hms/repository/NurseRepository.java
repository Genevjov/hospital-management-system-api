package ua.dlubovskyi.hms.repository;

import org.springframework.data.repository.CrudRepository;
import ua.dlubovskyi.hms.entity.NurseEntity;

public interface NurseRepository extends CrudRepository<NurseEntity, String> {
}
