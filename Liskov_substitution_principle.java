//*************************************************************************
// TITLE : A java program to demonstrate Liskov substitution principle
// AUTHOR : MD SABBIR HASAN, UNDERGRADUATE STUDENT (2ND YEAR) Of KHULNA UNIVERSITY
//*************************************************************************


import java.util.ArrayList;
import java.util.List;

/**
 * Interface defining the behavior of an employee.
 */
interface Employee {
    String getDetails();
    double calculateSalary();
}

/**
 * Class representing a permanent employee.
 */
class PermanentEmployee implements Employee {
    private String name;
    private double salary;

    public PermanentEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getDetails() {
        return "Name: " + name + ", Type: Permanent";
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}

/**
 * Class representing a contract employee.
 */
class ContractEmployee implements Employee {
    private String name;
    private double wage;
    private int hoursWorked;

    public ContractEmployee(String name, double wage, int hoursWorked) {
        this.name = name;
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getDetails() {
        return "Name: " + name + ", Type: Contract";
    }

    @Override
    public double calculateSalary() {
        return wage * hoursWorked;
    }
}

/**
 * Class representing an employee management system.
 */
class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    /**
     * Adds an employee to the management system.
     *
     * @param employee The employee to be added
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Calculates the total salary of all employees in the management system.
     *
     * @return The total salary of all employees
     */
    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }

    /**
     * Prints details of all employees in the management system.
     */
    public void printEmployeeDetails() {
        for (Employee employee : employees) {
            System.out.println(employee.getDetails() + ", Salary: $" + employee.calculateSalary());
        }
    }
}

public class Liskov_substitution_principle {
    public static void main(String[] args) {
        // Create an employee management system
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // Add permanent employees to the system
        ems.addEmployee(new PermanentEmployee("Hasan", 50000));
        ems.addEmployee(new PermanentEmployee(" Sabbir", 60000));

        // Add contract employees to the system
        ems.addEmployee(new ContractEmployee("Fahim", 20, 160));
        ems.addEmployee(new ContractEmployee("Sakib", 25, 180));

        // Print details of all employees in the system
        ems.printEmployeeDetails();

        // Calculate total salary of all employees in the system
        double totalSalary = ems.calculateTotalSalary();
        System.out.println("Total Salary: $" + totalSalary);
    }
}
