package HomeWork_25_2.HomeWork_25_2.Controller;

import HomeWork_25_2.HomeWork_25_2.Employee;
import HomeWork_25_2.HomeWork_25_2.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getMax")
    public Employee getMax (@RequestParam ("department") int department) {
        return departmentService.getMaxSalary(department);
    }
    @GetMapping("/getMin")
    public Employee getMin (@RequestParam ("department") int department) {
        return departmentService.getMinSalary(department);
    }
    @GetMapping("/getFromDep")
    public List<Employee> getFromDep (@RequestParam ("department") int department) {
        return departmentService.getFromDepartment(department);
    }
    @GetMapping("/getAllDep")
    public Map<Integer, List <Employee>> getAllDep() {
        return departmentService.getAllDepartment();
    }
}
