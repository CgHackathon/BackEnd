package App.services.interfaces;

import App.models.Employee;
import App.models.restModles.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    void addEmployee(EmployeeRequest employeeRequest);
    List<Employee> getAllEmployees();

    Employee getEmployee(String employeeEmail);

    void modifyEmployee(EmployeeRequest employee);
}
