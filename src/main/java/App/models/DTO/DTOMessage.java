package App.models.DTO;

import lombok.Data;

import java.util.Date;


@Data
public class DTOMessage {
    private String from;
    private String to;
    private String Content;
    private Date date;
}
