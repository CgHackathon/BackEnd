package App.controller;


import App.models.DTO.DTOMessage;
import App.models.Prescription;
import App.models.Report;
import App.security.JWT.JwtTokenUtil;
import App.services.interfaces.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    ReportService reportService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/sendReport")
    public void sendReport(@RequestBody DTOMessage Report) {
        reportService.sendReport(Report);
    }

    @GetMapping("/getReport")
    public List<Report> getReport(@RequestHeader("Authorization") String token) {
        String userName = jwtTokenUtil.getUserNameFromToken(jwtTokenUtil.parseHeaderAuth(token));
        return reportService.getByFromUserName(userName);
    }
}
