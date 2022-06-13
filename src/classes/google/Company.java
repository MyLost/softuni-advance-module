package classes.google;

public class Company {
    private String companyName;
    private String department;
    private Double salary;

    public Company(String companyName, String department, Double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.companyName + " " + this.department + " " + String.format("%.2f", this.salary);
    }
}
