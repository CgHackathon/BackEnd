package App.controller;


import App.models.DTO.DTOMessage;
import App.models.Donation;
import App.services.interfaces.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/donation")
@RestController
public class DonationController {
    @Autowired
    DonationService donationService;

    @PostMapping("/donate")
    public void donate(@RequestBody Donation donation) {
        donationService.donate(donation);
    }
}
