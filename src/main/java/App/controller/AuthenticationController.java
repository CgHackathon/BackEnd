package App.controller;

import App.models.DTO.LogInRequest;
import App.models.DTO.SignEmployeeRequest;
import App.models.Employee;
import App.models.User;
import App.repos.EmployeeRepo;
import App.repos.UserRepo;
import App.security.JWT.JwtTokenUtil;
import App.services.interfaces.EmployeeService;
import App.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LogInRequest request) {
        return userService.login(request);
    }

    @PostMapping("/signUser")
    public void signUser(@RequestBody User user) {
        userService.signUser(user);
    }

    @PostMapping("/signEmployee")
    public void signEmployee(@RequestBody SignEmployeeRequest employee) {
        employeeService.signEmployee(employee);
    }

}
