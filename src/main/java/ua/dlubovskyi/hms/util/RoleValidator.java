package ua.dlubovskyi.hms.util;

import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;

public class RoleValidator {

    public static boolean isRoleEqual(User target, Role role) {
        return target.getProfileType().equals(role.name());
    }
}
