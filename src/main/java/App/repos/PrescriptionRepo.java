package App.repos;

import App.models.Message;
import App.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepo extends JpaRepository<Prescription,Integer> {
    List<Prescription> getByFrom(String userName);
}
