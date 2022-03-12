package App.models.DTO;

import App.models.Employee;
import App.models.Role;
import App.models.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SignEmployeeRequest {
    @NotBlank(message = "User Name is required")
    private String userName;

    @NotBlank(message = "User first Name is required")
    private String fName;

    @NotBlank(message = "User Last Name is required")
    private String lName;

    @Email(message = "Email not valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "User phone is required")
    private String phoneNumber;

    @NotBlank(message = "User Password is required")
    private String password;

    @NotBlank(message = "Role is required")
    private Role role;

    @NotBlank(message = "Institution is required ")
    private String Institution;

    @NotBlank(message = "Verification URl is required")
    private String verificationURL;
}
