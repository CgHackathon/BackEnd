package App.services.Implementation;

import App.models.DTO.DTOMessage;
import App.models.Report;
import App.models.Role;
import App.repos.ReportRepo;
import App.repos.UserRepo;
import App.services.interfaces.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepo reportRepo;
    @Autowired
    UserRepo userRepo;


    @Override
    public void sendReport(DTOMessage message) {
        Report r = getLetter(message);
        if(r.getTo().getRole() != Role.Doctor)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Error: Report must be sent to doctor role");
        reportRepo.save(r);
    }

    @Override
    public List<Report> getByFromUserName(String userName) {
        return reportRepo.getByFromUserName(userName);
    }

    @Override
    public Report getLetter(DTOMessage dtoMessage) {
        Report l = new Report();
        l.setFrom(userRepo.getById(dtoMessage.getFrom()));
        l.setTo(userRepo.getById(dtoMessage.getTo()));
        l.setTime(new Date());
        l.setContent(dtoMessage.getContent());
        return l;
    }

    @Override
    public List<Report> getByToUserName(String userName) {
        return reportRepo.getByToUserName(userName);
    }

}
