package App.services.Implementation;

import App.models.DTO.DTOMessage;
import App.models.Message;
import App.models.Prescription;
import App.repos.PrescriptionRepo;
import App.services.interfaces.LetterService;
import App.services.interfaces.PrescriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptServiceImpl implements PrescriptService {
    @Autowired
    PrescriptionRepo prescriptionRepo;
    @Autowired
    LetterService letterService;

    @Override
    public void sendPrescript(DTOMessage message) {
        prescriptionRepo.save((Prescription) letterService.getLetter(message));
    }

    @Override
    public List<Prescription> get(String userName) {
        return prescriptionRepo.getByFrom(userName);
    }
}
