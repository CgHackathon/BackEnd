package App.services.Implementation;

import App.models.DTO.SignEmployeeRequest;
import App.models.Employee;
import App.models.User;
import App.repos.InstitutionRepo;
import App.services.interfaces.EmployeeService;
import App.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    UserService userService;
    @Autowired
    InstitutionRepo institutionRepo;

    @Override
    public Employee getEmployee(SignEmployeeRequest signEmployeeRequest) {
        User u = new User();
        u.setUserName(signEmployeeRequest.getUserName());
        u.setPassword(signEmployeeRequest.getPassword());
        u.setFName(signEmployeeRequest.getFName());
        u.setRole(signEmployeeRequest.getRole());
        u.setLName(signEmployeeRequest.getLName());
        u.setEmail(signEmployeeRequest.getEmail());
        u.setPhoneNumber(signEmployeeRequest.getPhoneNumber());
        u = userService.handleUser(u);
        Employee e = new Employee();
        e.setUser(u);
        e.setInstitution(institutionRepo.getById(signEmployeeRequest.getInstitution()));
        e.setVerificationURL(signEmployeeRequest.getVerificationURL());
        e.setVerified(true);
        return e;
    }
}
