package ua.dlubovskyi.hms.util.strategy.profile;

import org.springframework.stereotype.Component;
import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.util.strategy.profile.impl.DoctorChecker;
import ua.dlubovskyi.hms.util.strategy.profile.impl.HospitalAdminChecker;
import ua.dlubovskyi.hms.util.strategy.profile.impl.NurseChecker;
import ua.dlubovskyi.hms.util.strategy.profile.impl.PatientChecker;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProfileCheckingStrategy {

    private Map<Role, Checker> checkerMap;

    public ProfileCheckingStrategy() {
        checkerMap = new HashMap<>();

        checkerMap.put(Role.PATIENT, new PatientChecker());
        checkerMap.put(Role.NURSE, new NurseChecker());
        checkerMap.put(Role.HOSPITAL_ADMIN, new HospitalAdminChecker());
    }

    public boolean isGranted(User target, User profileOwner) {
        return checkerMap.get(Role.valueOf(target.getProfileType())).check(profileOwner, target);
    }
}
