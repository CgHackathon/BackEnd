package App.services.Implementation;

import App.models.DTO.DTOMessage;
import App.models.Message;
import App.repos.MessageRepo;
import App.services.interfaces.LetterService;
import App.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepo messageRepo;
    @Autowired
    LetterService letterService;

    @Override
    public void sendMessage(DTOMessage message) {
        messageRepo.save((Message) letterService.getLetter(message));
    }

    @Override
    public List<Message> get(String user) {
        return messageRepo.findByFromUserNameOrToUserNameOrderByTimeDesc(user,user);
    }


}
