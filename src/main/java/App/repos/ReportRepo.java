package App.repos;

import App.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepo extends JpaRepository<Report,Integer> {
    List<Report> getByFrom(String userName);

    List<Report> getByToUserName(String userName);
}
