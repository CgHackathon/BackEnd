package App.controller;

import App.models.DTO.SignUpRequest;
import App.models.User;
import App.repos.UserRepo;
import App.security.JWT.JwtTokenUtil;
import App.services.interfaces.UserService;
import App.validation.AdvanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Map<String,String> request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.get("userName"), request.get("password")));
        final User user = userRepo.getById(request.get("userName"));
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok("{\"token\": \"" + token + "\"}");
    }

//    @Validated({AdvanceInfo.class})
    @PostMapping("/signUser")
    public void signUser(@RequestBody User user) {
        if (userRepo.existsById(user.getEmail()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: Email is already in use!");
        userRepo.save(userService.handleUser(user));
    }

    @PostMapping("/signEmployee")
    public void signUp(@RequestBody User user) {
        if (userRepo.existsById(user.getEmail()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: Email is already in use!");
        userRepo.save(userService.handleUser(user));

    }

}
