package ua.dlubovskyi.hms.security;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;

import static com.google.common.hash.Hashing.sha256;

@Component
public class Encoder {

    public String encode(String password) {
        return sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }

    public String doAES(String plainText, Key key, int mode) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, key);
            return Arrays.toString(cipher.doFinal());
        } catch (Exception e) {
            return null;
        }
    }
}
