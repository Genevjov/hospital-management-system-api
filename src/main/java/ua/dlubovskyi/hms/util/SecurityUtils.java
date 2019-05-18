package ua.dlubovskyi.hms.util;

import org.springframework.stereotype.Component;
import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.UserService;

import java.util.Arrays;

import static java.util.Objects.nonNull;

@Component
public class SecurityUtils {

    private TokenService tokenService;
    private UserService userService;

    public SecurityUtils(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    public boolean isActionGrated(String authToken, Role... roles) {
        if (tokenService.isTokenValid(authToken)) {
            String userId = tokenService.getUserIdByToken(authToken);
            if (nonNull(userId)) {
                User user = userService.findById(userId);
                return (nonNull(user) && Arrays.stream(roles)
                        .anyMatch(role -> user.getProfileType().equals(role.name())));
            }
        }
        return false;
    }
}
