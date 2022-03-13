package App.models.DTO;

import lombok.Data;

@Data
public class LogInRequest {
    private String userName;
    private String password;
}
