package ua.dlubovskyi.hms.util;

import org.springframework.stereotype.Component;
import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.UserService;
import ua.dlubovskyi.hms.util.strategy.profile.ProfileCheckingStrategy;

import java.util.Arrays;

import static java.util.Objects.nonNull;

@Component
public class SecurityUtils {

    private TokenService tokenService;
    private UserService userService;
    private ProfileCheckingStrategy profileCheckingStrategy;

    public SecurityUtils(TokenService tokenService, UserService userService, ProfileCheckingStrategy profileCheckingStrategy) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.profileCheckingStrategy = profileCheckingStrategy;
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

    public boolean isGrantedToWatchProfile(String authToken, User userToCheck) {
        if (isActionGrated(authToken, Role.SERVICE_ADMIN)) {
            return true;
        } else {
            User user = userService.findById(tokenService.getUserIdByToken(authToken));
            return profileCheckingStrategy.isGranted(user, userToCheck);
        }
    }
}
