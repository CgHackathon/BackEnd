package App.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import App.models.User;

public interface UserRepo extends JpaRepository<User, String> {
}
