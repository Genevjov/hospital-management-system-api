package ua.dlubovskyi.hms.service.impl;

import ua.dlubovskyi.hms.service.TokenService;

import java.util.UUID;

public class TokenServiceImpl implements TokenService {


    @Override
    public boolean isTokenValid(UUID token) {
        return false;
    }

    @Override
    public void invalidateToken(UUID token) {

    }
}
