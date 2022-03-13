package App.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Caravan {
    @Id
    private String Name;

    private String location;

    @OneToMany
    private List<Employee> employees = new ArrayList<>();
    @OneToMany
    private List<User> patients = new ArrayList<>();
}
