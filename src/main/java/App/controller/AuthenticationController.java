package App.controller;

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
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    EmployeeService employeeService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.get("userName"), request.get("password")));
        final User user = userRepo.getById(request.get("userName"));
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok("{\"token\": \"" + token + "\"}");
    }

    @PostMapping("/signUser")
    public void signUser(@RequestBody User user) {
        if (userRepo.existsById(user.getUsername()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: User name is already in use!");
        userRepo.save(userService.handleUser(user));
    }

    @PostMapping("/signEmployee")
    public void signUp(@RequestBody SignEmployeeRequest employee) {
        if (userRepo.existsById(employee.getUserName()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: User Name is already in use!");
        try{
            Employee e = employeeService.getEmployee(employee);
            employeeRepo.save(e);
        }catch (Exception x){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, x.getMessage());
        }
    }

}
