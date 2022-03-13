package App.services.Implementation;

import App.models.DTO.DTOMessage;
import App.models.Message;
import App.repos.MessageRepo;
import App.repos.UserRepo;
import App.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepo messageRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public void sendMessage(DTOMessage message) {
        messageRepo.save(getLetter(message));
    }

    @Override
    public List<Message> get(String user) {
        return messageRepo.findByFromUserNameOrToUserNameOrderByTimeDesc(user,user);
    }

    @Override
    public Message getLetter(DTOMessage dtoMessage) {
        Message l = new Message();
        l.setFrom(userRepo.getById(dtoMessage.getFrom()));
        l.setTo(userRepo.getById(dtoMessage.getTo()));
        l.setTime(new Date());
        l.setContent(dtoMessage.getContent());
        return l;
    }


}
