package ua.dlubovskyi.hms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dlubovskyi.hms.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    Optional<User> findById(String id);

}
