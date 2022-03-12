package App.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import App.models.Employee;
import App.models.restModles.EmployeeRequest;
import App.repos.EmployeeRepo;
import App.repos.StoreRepo;
import App.repos.UserRepo;

import java.util.List;

@Service
public class EmployeeServiceImpl implements App.services.interfaces.EmployeeService {

    @Autowired
    StoreRepo storeRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    UserServiceImpl userService;

    @Override
    public void addEmployee(EmployeeRequest employeeRequest) {
        if (userRepo.existsById(employeeRequest.getUser().getEmail()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: Email is already in use!");
        Employee e = new Employee();
        e.setUser(userService.handleUser(employeeRequest.getUser()));
        e.setStore(storeRepo.getById(employeeRequest.getStore()));
        e.setSalary(employeeRequest.getSalary());
        employeeRepo.save(e);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployee(String employeeEmail) {
        return employeeRepo.getById(employeeEmail);
    }

    @Override
    @Transactional
    public void modifyEmployee(EmployeeRequest employee) {
        Employee e = employeeRepo.getById(employee.getUser().getEmail());
        e.setUser(employee.getUser());
        e.setStore(storeRepo.getById(employee.getStore()));
        e.setSalary(employee.getSalary());
        employeeRepo.save(e);
    }
}
