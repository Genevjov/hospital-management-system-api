package ua.dlubovskyi.hms.service.impl;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final EntityManager entityManager;
    private final UserRepository userRepository;

    public UserService(EntityManager entityManager, UserRepository userRepository) {
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findUserByEmailAndPass(String email, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> user = userCriteriaQuery.from(User.class);
        Predicate emailCondition = criteriaBuilder.equal(user.get("email"), email);
        Predicate passwordCondition = criteriaBuilder.equal(user.get("password"), password);
        userCriteriaQuery.where(emailCondition, passwordCondition);
        List<User> foundUsers = entityManager.createQuery(userCriteriaQuery).getResultList();
        if (!foundUsers.isEmpty()) {
            return foundUsers.get(0);
        }
        return null;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUserPassword(User userForUpdate) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
        Root root = criteriaUpdate.from(User.class);
        criteriaUpdate.set("password", userForUpdate.getPassword());
        criteriaUpdate.where(criteriaBuilder.equal(root.get("userId"), userForUpdate.getUserId()));
        entityManager.createQuery(criteriaUpdate).executeUpdate();
    }
}
