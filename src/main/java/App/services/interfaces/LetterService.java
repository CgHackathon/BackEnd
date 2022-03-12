package App.services.interfaces;

import App.models.DTO.DTOMessage;
import App.models.Letter;

public interface LetterService {
    Letter getLetter(DTOMessage dtoMessage);
}
