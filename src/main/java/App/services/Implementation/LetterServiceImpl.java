package App.services.Implementation;

import App.models.DTO.DTOMessage;
import App.models.Letter;
import App.models.Message;
import App.repos.UserRepo;
import App.services.interfaces.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LetterServiceImpl implements LetterService {

    @Autowired
    UserRepo userRepo;

    @Override
    public Letter getLetter(DTOMessage dtoMessage) {
        Letter l = new Message();
        l.setFrom(userRepo.getById(dtoMessage.getFrom()));
        l.setTo(userRepo.getById(dtoMessage.getTo()));
        l.setTime(dtoMessage.getDate());
        l.setContent(dtoMessage.getContent());
        return l;
    }
}
