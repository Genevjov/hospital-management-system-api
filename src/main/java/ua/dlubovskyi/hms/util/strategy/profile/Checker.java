package ua.dlubovskyi.hms.util.strategy.profile;

import ua.dlubovskyi.hms.entity.User;

public interface Checker {

    boolean check(User profileOwner, User target);
}
