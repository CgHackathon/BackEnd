package App.controller;

import App.models.User;
import App.repos.MessageRepo;
import App.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/")
@RestController
public class test {

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    MessageService messageService;

    @GetMapping("test")
    private Object Hello() {
        return new User();
    }
}
