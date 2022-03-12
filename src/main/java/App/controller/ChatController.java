package App.controller;


import App.models.DTO.DTOMessage;
import App.models.Message;
import App.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RequestMapping("/chat")
@RestController
public class ChatController {

    @Autowired
    MessageService messageService;

    @PostMapping("/send")
    public void send(@RequestBody DTOMessage message) {
        messageService.sendMessage(message);
    }

    @GetMapping("/get")
    public List<Message> get(@RequestParam(name = "user") String User) {
        return messageService.get(User);
    }
}
