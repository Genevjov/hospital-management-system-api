package ua.dlubovskyi.hms.service;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.AuthToken;

@Service
public interface TokenService {

    boolean isTokenValid(String token);

    void invalidateToken(String token);

    AuthToken generateAuthTokenForUser(String userId);

    void updateToken(String userId);
}
