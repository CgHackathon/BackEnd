package App.controller;


import App.models.DTO.DTOMessage;
import App.models.Prescription;
import App.models.Report;
import App.security.JWT.JwtTokenUtil;
import App.services.interfaces.PrescriptService;
import App.services.interfaces.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping("/doctor")
@RestController
public class DoctorController {
    @Autowired
    PrescriptService prescriptService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    ReportService reportService;

    @PostMapping("/sendPrescript")
    public void sendPrescript(@RequestBody DTOMessage prescription) {
        prescriptService.sendPrescript(prescription);
    }


    @GetMapping("/getPrescript")
    public List<Prescription> getPrescript(@RequestHeader("Authorization") String token) {
        String userName = jwtTokenUtil.getUserNameFromToken(jwtTokenUtil.parseHeaderAuth(token));
        return prescriptService.get(userName);
    }

    @GetMapping("/getReport")
    public List<Report> getReport(@RequestHeader("Authorization") String token) {
        String userName = jwtTokenUtil.getUserNameFromToken(jwtTokenUtil.parseHeaderAuth(token));
        return reportService.getByTo(userName);
    }

}
