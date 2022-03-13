package App.models.DTO;

import App.models.Role;
import App.models.User;
import lombok.Data;


@Data
public class UserDTO {

    public UserDTO(User user){
        userName = user.getUsername();
        fName = user.getFName();
        lName = user.getLName();
        email = user.getEmail();
        phoneNumber = user.getPhoneNumber();
        role = user.getRole();
    }

    private String userName;

    private String fName;

    private String lName;

    private String email;

    private String phoneNumber;

    private Role role;
}
