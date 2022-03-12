package App.models;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Institution {
    @Id
    private String Name;
    private String location;
}
