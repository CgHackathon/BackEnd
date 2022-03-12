package App.models.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank(message = "User Email is required")
    private String userName;

    @NotBlank(message = "User Password is required")
    private String password;
}