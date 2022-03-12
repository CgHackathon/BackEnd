package App.repos;

import App.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepo extends JpaRepository<Store, Integer> {
}
