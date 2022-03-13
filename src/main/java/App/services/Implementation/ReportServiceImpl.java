package App.services.Implementation;

import App.models.DTO.DTOMessage;
import App.models.Prescription;
import App.models.Report;
import App.repos.ReportRepo;
import App.services.interfaces.LetterService;
import App.services.interfaces.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepo reportRepo;
    @Autowired
    LetterService letterService;


    @Override
    public void sendReport(DTOMessage message) {
        reportRepo.save((Report) letterService.getLetter(message));
    }

    @Override
    public List<Report> getByFrom(String userName) {
        return reportRepo.getByFrom(userName);
    }

    @Override
    public List<Report> getByToUserName(String userName) {
        return reportRepo.getByToUserName(userName);
    }

}
