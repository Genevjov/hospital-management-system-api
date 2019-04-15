package ua.dlubovskyi.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.bean.User;
import ua.dlubovskyi.hms.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class UserService {

    @Autowired
    EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public User findById(String id) {
        return userRepository.findById(id).get();
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
}
