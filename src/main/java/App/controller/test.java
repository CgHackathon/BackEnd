package App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import App.repos.UserRepo;

@CrossOrigin
@RequestMapping("/")
@RestController
public class test {

    @Autowired
    UserRepo userRepo;

    @GetMapping("test")
    private Object Hello() {
        return userRepo.topUser(10);
    }
}