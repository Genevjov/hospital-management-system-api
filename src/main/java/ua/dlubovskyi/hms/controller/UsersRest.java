package ua.dlubovskyi.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.UserService;

import static java.util.Objects.nonNull;

@RestController
public class UsersRest {

    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public UsersRest(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserByToken(@RequestHeader("Auth") String authToken) {
        String id = tokenService.getUserIdByToken(authToken);
        if (nonNull(id)) {
            User user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
