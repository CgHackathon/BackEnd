package App.services.interfaces;

import App.models.User;

import java.util.List;

public interface CustomerService {

    List<User> topUsers(Integer count);
}
