package ua.dlubovskyi.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dlubovskyi.hms.dto.change.ChangePasswordDto;
import ua.dlubovskyi.hms.dto.create.CreateUserDto;
import ua.dlubovskyi.hms.entity.Message;
import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.security.Encoder;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.UserService;
import ua.dlubovskyi.hms.util.SecurityUtils;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
public class UsersRest {

    private final UserService userService;
    private final TokenService tokenService;
    private final Encoder encoder;
    private final SecurityUtils securityUtils;
    private final ConversionService conversionService;

    @Autowired
    public UsersRest(UserService userService, TokenService tokenService,
                     Encoder encoder, SecurityUtils securityUtils, ConversionService conversionService) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.encoder = encoder;
        this.securityUtils = securityUtils;
        this.conversionService = conversionService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> getUserByToken(@RequestHeader("Auth") String authToken) {
        String id = tokenService.getUserIdByToken(authToken);
        if (nonNull(id)) {
            User user = userService.findById(id);
            tokenService.updateToken(user.getUserId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/password/change")
    public ResponseEntity<Message> changePassword(@RequestHeader("Auth") String authToken,
                                                  @RequestBody ChangePasswordDto changePasswordDto) {
        String userId = tokenService.getUserIdByToken(authToken);
        if (nonNull(userId)) {
            tokenService.updateToken(userId);
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

    @GetMapping("/users")
    public ResponseEntity getAllUsers(@RequestHeader("Auth") String authToken) {
        if (securityUtils.isActionGrated(authToken, Role.SERVICE_ADMIN)) {
            tokenService.updateToken(tokenService.getUserIdByToken(authToken));
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<List<User>>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/userProfile/{id}")
    public ResponseEntity<User> getUserInfo(@RequestHeader("Auth") String authToken, @PathVariable("id") String id) {
        User user = userService.findById(id);
        tokenService.updateToken(tokenService.getUserIdByToken(authToken));
        if (nonNull(user)) {
            if (securityUtils.isGrantedToWatchProfile(authToken, user)) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/user")
    public ResponseEntity<User> addUser(@RequestHeader("Auth") String authToken, @RequestBody CreateUserDto createUserDto) {
        if (securityUtils.isActionGrated(authToken, Role.SERVICE_ADMIN, Role.HOSPITAL_ADMIN)) {

            userService.createUser(conversionService.convert(createUserDto, User.class));
        }
        return new ResponseEntity<>(conversionService.convert(createUserDto, User.class), HttpStatus.OK);
    }


}
