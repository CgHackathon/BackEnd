package App.services.Implementation;

import App.models.DTO.DTOMessage;
import App.models.Prescription;
import App.repos.PrescriptionRepo;
import App.repos.UserRepo;
import App.services.interfaces.PrescriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptServiceImpl implements PrescriptService {
    @Autowired
    PrescriptionRepo prescriptionRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public void sendPrescript(DTOMessage message) {
        prescriptionRepo.save(getLetter(message));
    }

    @Override
    public List<Prescription> get(String userName) {
        return prescriptionRepo.getByFromUserName(userName);
    }

    @Override
    public Prescription getLetter(DTOMessage dtoMessage) {
        Prescription l = new Prescription();
        l.setFrom(userRepo.getById(dtoMessage.getFrom()));
        l.setTo(userRepo.getById(dtoMessage.getTo()));
        l.setTime(dtoMessage.getDate());
        l.setContent(dtoMessage.getContent());
        return l;
    }
}
