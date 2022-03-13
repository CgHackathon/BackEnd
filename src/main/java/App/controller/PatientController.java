package App.controller;

import App.models.Prescription;
import App.models.Report;
import App.security.JWT.JwtTokenUtil;
import App.services.interfaces.PrescriptService;
import App.services.interfaces.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/patient")
@RestController
public class PatientController {
    @Autowired
    ReportService reportService;

    @Autowired
    PrescriptService prescriptService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @GetMapping("/getReport")
    public List<Report> getReport(@RequestHeader("Authorization") String token) {
        String userName = jwtTokenUtil.getUserNameFromToken(jwtTokenUtil.parseHeaderAuth(token));
        return reportService.getByToUserName(userName);
    }

    @GetMapping("/getPrescript")
    public List<Prescription> getPrescript(@RequestHeader("Authorization") String token) {
        String userName = jwtTokenUtil.getUserNameFromToken(jwtTokenUtil.parseHeaderAuth(token));
        return prescriptService.getByToUserName(userName);
    }
}
