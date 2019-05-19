package ua.dlubovskyi.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.dto.auth.AuthUserDto;
import ua.dlubovskyi.hms.dto.auth.LogoutDto;
import ua.dlubovskyi.hms.entity.AuthToken;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.security.Encoder;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.UserService;

import static java.util.Objects.nonNull;

@RestController
public class AuthRest {

    private final UserService userService;
    private TokenService tokenService;
    private Encoder encoder;

    public AuthRest(UserService userService, TokenService tokenService, Encoder encoder) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.encoder = encoder;
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthToken> authUser(@RequestBody AuthUserDto authUserDto) {
        String encodedPassword = encoder.encode(authUserDto.getPassword());
        User user = userService.findUserByEmailAndPass(authUserDto.getEmail(), encodedPassword);
        if (nonNull(user)) {
            AuthToken authToken = tokenService.generateAuthTokenForUser(user.getUserId());
            return new ResponseEntity<>(authToken, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/logout")
    public ResponseEntity logoutUser(@RequestBody LogoutDto logoutDto) {
        System.out.println(logoutDto.getUserId());
        tokenService.invalidateToken(logoutDto.getUserId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
