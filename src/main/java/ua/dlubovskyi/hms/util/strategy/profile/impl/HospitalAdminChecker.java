package ua.dlubovskyi.hms.util.strategy.profile.impl;

import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.util.strategy.profile.Checker;

public class HospitalAdminChecker implements Checker {
    @Override
    public boolean check(User profileOwner, User target) {
        return target.getHospitalId().equals(profileOwner.getProfileType());
    }
}
