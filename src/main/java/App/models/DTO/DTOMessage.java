package App.models.DTO;

import lombok.Data;

@Data
public class DTOMessage {
    private String from;
    private String to;
    private String content;
}
