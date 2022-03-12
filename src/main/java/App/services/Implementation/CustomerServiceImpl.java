package App.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import App.models.User;
import App.repos.UserRepo;

import java.util.List;

@Service
public class CustomerServiceImpl implements App.services.interfaces.CustomerService {
    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> topUsers(Integer count) {
        return null;
    }
}
