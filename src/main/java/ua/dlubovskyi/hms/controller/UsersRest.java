package ua.dlubovskyi.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dlubovskyi.hms.dto.change.ChangeEmailDto;
import ua.dlubovskyi.hms.dto.change.ChangePasswordDto;
import ua.dlubovskyi.hms.entity.Message;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.security.Encoder;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.UserService;

import static java.util.Objects.nonNull;

@RestController
public class UsersRest {

    private final UserService userService;
    private final TokenService tokenService;
    private final Encoder encoder;

    @Autowired
    public UsersRest(UserService userService, TokenService tokenService, Encoder encoder) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.encoder = encoder;
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

    @PostMapping("/password/change")
    public ResponseEntity<Message> changePassword(@RequestHeader("Auth") String authToken,
                                                  @RequestBody ChangePasswordDto changePasswordDto) {
        String userId = tokenService.getUserIdByToken(authToken);
        if (nonNull(userId)) {
            User user = userService.findById(userId);
            String encodedOldPassword = encoder.encode(changePasswordDto.getOldPassword());
            Message message = new Message();
            if (user.getPassword().equals(encodedOldPassword)) {
                if (!user.getPassword().equals(changePasswordDto.getNewPassword()) &&
                        changePasswordDto.getNewPassword().equals(
                                changePasswordDto.getNewPasswordConfirmation())) {
                    user.setPassword(encoder.encode(changePasswordDto.getNewPassword()));
                    userService.updateUserPassword(user);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
                message.setText("Passwords are not equal.");
                return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            }
            message.setText("Current password is wrong.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/email/change")
    public ResponseEntity<Message> changeEmail(@RequestHeader("Auth") String authToken,
                                               @RequestBody ChangeEmailDto changeEmailDto) {
        String userId = tokenService.getUserIdByToken(authToken);
        if (nonNull(userId)) {
            User user = userService.findById(userId);
            Message message = new Message();
            if (!user.getEmail().equals(changeEmailDto.getEmail())) {
                userService.updateUserPassword(user);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            message.setText("Passwords are not equal.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }


}