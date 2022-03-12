package App.services.interfaces;

import App.models.DTO.DTOMessage;
import App.models.Message;

import java.util.List;

public interface MessageService {
    void sendMessage(DTOMessage message);
    List<Message> get (String user);
}
