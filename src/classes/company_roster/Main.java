package classes.company_roster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");
            String name = inputTokens[0];
            Double salary = Double.parseDouble(inputTokens[1]);
            String position = inputTokens[2];
            String departmentName = inputTokens[3];
            String email = null;
            Integer age = null;
            double  highestAverageSalary = 0;
            Department departmentWithHighestAverageSalary = null;
            if(inputTokens.length > 4 && inputTokens[4].contains("@")) {
                email = inputTokens[4];
            }
            if(inputTokens.length > 4 && !inputTokens[4].contains("@")) {
                age = Integer.valueOf(inputTokens[4]);
            }
            if(inputTokens.length > 5) {
                age = Integer.valueOf(inputTokens[5]);
            }
            Employee employee = new Employee(name, salary, position, departmentName, email, age);
            if(departments.containsKey(departmentName)) {
                departments.get(departmentName).getEmployees().add(employee);
            } else {
                Department department = new Department(departmentName);
                departments.put(departmentName, department);
                departments.get(departmentName).getEmployees().add(employee);
            }
        }

        Department highestPaidDepartment =  departments.entrySet().stream()
                .max(Comparator.comparing(e-> e.getValue().getAverageSalary())).get()
                .getValue();

        System.out.println("Highest Average Salary: " + highestPaidDepartment.getName());
        highestPaidDepartment.getEmployees().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                        .forEach(System.out::println);
    }
}
