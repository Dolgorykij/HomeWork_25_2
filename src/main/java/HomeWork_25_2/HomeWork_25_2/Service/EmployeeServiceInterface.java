package HomeWork_25_2.HomeWork_25_2.Service;

import HomeWork_25_2.HomeWork_25_2.Employee;
import HomeWork_25_2.HomeWork_25_2.Exceptions.EmployeeAlreadyAddedException;
import HomeWork_25_2.HomeWork_25_2.Exceptions.EmployeeNotFoundException;
import HomeWork_25_2.HomeWork_25_2.Exceptions.EmployeeStorageIsFullException;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee add(String firstName, String lastName, int department, int salary) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    Employee find(String firstName, String lastName, int department, int salary) throws EmployeeNotFoundException;

    Employee remove(String firstName, String lastName);

    List<Employee> workerks();
}