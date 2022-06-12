package classes.company_roster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Double getAverageSalary () {
        return this.employees.stream().mapToDouble(e ->e.getSalary()).average().orElse(0);
    }
}
