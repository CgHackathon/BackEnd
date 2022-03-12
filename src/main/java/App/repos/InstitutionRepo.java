package App.repos;

import App.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepo extends JpaRepository<Institution, String> {
}
