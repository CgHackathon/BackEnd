package App.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@MappedSuperclass

public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "from_user")
    private User from;

    @ManyToOne
    @JoinColumn(name = "to_user")
    private User to;

    private String Content;

    private Date time;
}
