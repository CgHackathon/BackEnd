package App.services.interfaces;


import App.models.DTO.LogInRequest;
import App.models.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User handleUser(User user);

    User get(String userName);

    ResponseEntity<?> login(LogInRequest request);

    void signUser(User user);
}
