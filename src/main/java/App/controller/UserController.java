package App.controller;


import App.models.User;
import App.security.JWT.JwtTokenUtil;
import App.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @GetMapping("/getInfo")
    public User getInfo(@RequestHeader("Authorization") String token) {
        String userName = jwtTokenUtil.getUserNameFromToken(jwtTokenUtil.parseHeaderAuth(token));
        return userService.get(userName);
    }

}
