package App.services.Implementation;
import App.models.Donation;
import App.repos.DonationRepo;
import App.services.interfaces.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationServiceImpl implements DonationService {
    @Autowired
    DonationRepo donationRepo;

    @Override
    public void donate(Donation donation) {
        donationRepo.save(donation);
    }
}
