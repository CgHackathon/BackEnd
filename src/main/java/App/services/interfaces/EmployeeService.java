package App.services.interfaces;

import App.models.DTO.SignEmployeeRequest;
import App.models.Employee;

public interface EmployeeService {
    Employee getEmployee(SignEmployeeRequest signEmployeeRequest);
    boolean CheckVerification(String UserName);

    void signEmployee(SignEmployeeRequest employee);
}
