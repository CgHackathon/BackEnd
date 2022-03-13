package App.services.Implementation;

import App.models.DTO.SignEmployeeRequest;
import App.models.Employee;
import App.models.User;
import App.repos.EmployeeRepo;
import App.repos.InstitutionRepo;
import App.repos.UserRepo;
import App.services.interfaces.EmployeeService;
import App.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    UserService userService;
    @Autowired
    InstitutionRepo institutionRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    UserRepo userRepo;

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
//        e.setInstitution(signEmployeeRequest.getInstitution());
        e.setVerificationURL(signEmployeeRequest.getVerificationURL());
        e.setVerified(true);
        return e;
    }

    @Override
    public boolean CheckVerification(String userName) {
        return employeeRepo.getById(userName).isVerified();
    }

    @Override
    public void signEmployee(SignEmployeeRequest employee) {
        if (userRepo.existsById(employee.getUserName()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error: User Name is already in use!");
        try{
            Employee e = getEmployee(employee);
            employeeRepo.save(e);
        }catch (Exception x){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, x.getMessage());
        }
    }
}
