package App.services.interfaces;

import App.models.DTO.DTOMessage;
import App.models.Letter;
import App.models.Prescription;
import App.models.Report;

import java.util.List;

public interface ReportService {
    void sendReport(DTOMessage message);

    List<Report> getByToUserName(String userName);

    List<Report> getByFromUserName(String userName);

    Report getLetter(DTOMessage dtoMessage);
}
