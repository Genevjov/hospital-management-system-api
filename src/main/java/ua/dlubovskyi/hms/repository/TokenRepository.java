package ua.dlubovskyi.hms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dlubovskyi.hms.entity.AuthToken;

@Repository
public interface TokenRepository extends CrudRepository<AuthToken, String> {

}
