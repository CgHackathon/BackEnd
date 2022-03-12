package App.repos;

import App.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message,Integer> {
    List<Message> findByFromUserNameOrToUserNameOrderByTimeDesc(String From,String To);
}
