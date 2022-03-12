package App.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {
    @Id
    @JsonIgnore
    private String id;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name")
    private User user;

    @OneToOne
    private Institution Institution;

    private String verificationURL;

    private boolean verified = true;
}
