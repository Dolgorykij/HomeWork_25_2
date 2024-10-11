package HomeWork_25_2.HomeWork_25_2.Service;

import HomeWork_25_2.HomeWork_25_2.Employee;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMaxSalary (int department) {
        return employeeService.workerks()
                .stream()
                .filter(employee -> department == employee.getDepartment())
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }

    public Employee getMinSalary (int department) {
        return employeeService.workerks()
                .stream()
                .filter(employee -> department == employee.getDepartment())
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }
    public List<Employee> getFromDepartment (int department) {
        return employeeService.workerks()
                .stream()
                .filter(employee -> department == employee.getDepartment())
                .toList();
    }
    public Map<Integer , List <Employee>> getAllDepartment () {
        return employeeService.workerks()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
