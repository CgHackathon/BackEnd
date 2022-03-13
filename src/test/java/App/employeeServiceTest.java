package App;


import App.services.interfaces.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class employeeServiceTest {

    @MockBean
    EmployeeService employeeService;

    @Test
    public void testGetEmployees() throws Exception {
    }

}
