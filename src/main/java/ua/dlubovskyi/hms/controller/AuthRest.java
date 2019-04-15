package ua.dlubovskyi.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.bean.User;
import ua.dlubovskyi.hms.dto.auth.AuthUserDto;
import ua.dlubovskyi.hms.service.impl.UserService;

import static java.util.Objects.nonNull;

@RestController
public class AuthRest {

    @Autowired
    UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<User> authUser(@RequestBody AuthUserDto authUserDto) {
        User user = userService.findUserByEmailAndPass(authUserDto.getEmail(), authUserDto.getPassword());
        if (nonNull(user)) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
