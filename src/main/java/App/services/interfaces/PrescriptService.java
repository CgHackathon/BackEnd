package App.services.interfaces;

import App.models.DTO.DTOMessage;
import App.models.Message;
import App.models.Prescription;

import java.util.List;

public interface PrescriptService {
    void sendPrescript(DTOMessage message);

    List<Prescription> get(String userName);
}
