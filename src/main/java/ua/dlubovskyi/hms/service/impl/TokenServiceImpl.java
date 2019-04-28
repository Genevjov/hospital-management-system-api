package ua.dlubovskyi.hms.service.impl;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.AuthToken;
import ua.dlubovskyi.hms.repository.TokenRepository;
import ua.dlubovskyi.hms.service.TokenService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {


    private final TokenRepository tokenRepository;
    private final EntityManager entityManager;

    public TokenServiceImpl(TokenRepository tokenRepository,
                            EntityManager manager) {
        this.tokenRepository = tokenRepository;
        this.entityManager = manager;
    }

    @Override
    public boolean isTokenValid(String token) {
        Optional<AuthToken> authToken = tokenRepository.findById(token);
        return authToken
                .filter(value -> value.getExpirationDate().getTime() > new Date().getTime())
                .isPresent();
    }

    @Transactional
    @Override
    public void invalidateToken(String userId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<AuthToken> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(AuthToken.class);
        Root authTokenRoot = criteriaUpdate.from(AuthToken.class);
        criteriaUpdate.where(criteriaBuilder.equal(authTokenRoot.get("userId"), userId));
        criteriaUpdate.set("expirationDate", new Date());
        entityManager.createQuery(criteriaUpdate).executeUpdate();
    }

    @Override
    public AuthToken generateAuthTokenForUser(String userId) {
        String token = UUID.randomUUID().toString();
        AuthToken authToken = new AuthToken();
        authToken.setUserId(userId);
        authToken.setToken(token);
        authToken.setCreationDate(new Date());
        authToken.setExpirationDate(DateUtils.addMinutes(new Date(), 30));
        return tokenRepository.save(authToken);
    }

    @Transactional
    @Override
    public void updateToken(String userId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<AuthToken> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(AuthToken.class);
        Root<AuthToken> root = criteriaUpdate.from(AuthToken.class);
        Predicate userPredicate = criteriaBuilder.equal(root.get("userId"), userId);
        criteriaUpdate.set("expirationDate", DateUtils.addMinutes(new Date(), 30));
        criteriaUpdate.where(userPredicate);
        entityManager.createQuery(criteriaUpdate).executeUpdate();
    }
}
