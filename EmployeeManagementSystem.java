interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

abstract class Employee {
    private int id;
    private String name;
    private double baseSalary;

    Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Base Salary: " + baseSalary);
    }

    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee implements Department {
    private double bonus;
    private String department;

    FullTimeEmployee(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double calculateSalary() { return getBaseSalary() + bonus; }
    public void assignDepartment(String dept) { department = dept; }
    public String getDepartmentDetails() { return department; }
}

class PartTimeEmployee extends Employee implements Department {
    private int hours;
    private double rate;
    private String department;

    PartTimeEmployee(int id, String name, double rate, int hours) {
        super(id, name, 0);
        this.rate = rate;
        this.hours = hours;
    }

    public double calculateSalary() { return rate * hours; }
    public void assignDepartment(String dept) { department = dept; }
    public String getDepartmentDetails() { return department; }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] emps = {
                new FullTimeEmployee(1, "Rohit", 50000, 10000),
                new PartTimeEmployee(2, "Ananya", 500, 80)
        };

        ((Department)emps[0]).assignDepartment("IT");
        ((Department)emps[1]).assignDepartment("Support");

        for (Employee e : emps) {
            e.displayDetails();
            System.out.println("Department: " + ((Department)e).getDepartmentDetails());
            System.out.println("Total Salary: " + e.calculateSalary() + "\n");
        }
    }
}
