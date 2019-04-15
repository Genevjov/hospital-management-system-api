package ua.dlubovskyi.hms.service;

import java.util.UUID;

public interface TokenService {

    boolean isTokenValid(UUID token);

    void invalidateToken(UUID token);

}
