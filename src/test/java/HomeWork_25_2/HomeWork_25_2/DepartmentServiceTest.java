package HomeWork_25_2.HomeWork_25_2;

import HomeWork_25_2.HomeWork_25_2.Service.DepartmentService;
import HomeWork_25_2.HomeWork_25_2.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    public void setUp () {
        List<Employee> employeeList = new ArrayList<>(List.of(
                new Employee("Daniil" , "Viktorov" , 2 , 5800),
                new Employee("Daniluk" , "Papazoglo", 1 , 4000),
                new Employee("Tundra", "Vakytagin" , 3, 5000),
                new Employee("Oleg", "Shmatko" , 1, 3500)
        ));
        when(employeeService.workerks()).thenReturn(employeeList);
    }
    @Test
    public void getMaxSalaryTest () {
        assertThat(departmentService.getMaxSalary(1).getSalary()).isEqualTo(4000);
    }
    @Test
    public void getMinSalaryTest () {
        assertThat(departmentService.getMinSalary(1).getSalary()).isEqualTo(3500);
    }
    @Test
    public void getFromDepartmentTest () {
        var expected = List.of(
                new Employee("Daniluk" , "Papazoglo", 1 , 4000),
                new Employee("Oleg", "Shmatko" , 1, 3500)
        );
        assertThat(departmentService.getFromDepartment(1)).isEqualTo(expected);
    }
    @Test
    public void getAllDepartmentTest () {
        var expected = Map.of(
                1, List.of(new Employee("Daniluk" , "Papazoglo", 1 , 4000),new Employee("Oleg", "Shmatko" , 1, 3500)),
                2, List.of(new Employee("Daniil" , "Viktorov" , 2 , 5800)),
                3, List.of(new Employee("Tundra", "Vakytagin" , 3, 5000))
        );
        assertThat(departmentService.getAllDepartment()).isEqualTo(expected);
    }
}
