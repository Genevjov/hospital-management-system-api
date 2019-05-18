package ua.dlubovskyi.hms.security;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import static com.google.common.hash.Hashing.sha256;

@Component
public class PasswordEncoder {

    public String encode(String password) {
        return sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }
}
