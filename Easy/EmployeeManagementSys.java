import java.util.ArrayList;
import java.util.Scanner;

// Employee class
class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: $" + salary;
    }
}

public class prob1 {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Employee  2. Update Employee  3. Remove Employee  4. Search Employee  5. Display All  6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> updateEmployee();
                case 3 -> removeEmployee();
                case 4 -> searchEmployee();
                case 5 -> displayEmployees();
                case 6 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added!");
    }

    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        for (Employee e : employees) {
            if (e.id == id) {
                sc.nextLine();
                System.out.print("Enter New Name: ");
                e.name = sc.nextLine();
                System.out.print("Enter New Salary: ");
                e.salary = sc.nextDouble();
                System.out.println("Employee Updated!");
                return;
            }
        }
        System.out.println("Employee Not Found!");
    }

    static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = sc.nextInt();
        employees.removeIf(e -> e.id == id);
        System.out.println("Employee Removed!");
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee Not Found!");
    }

    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Found!");
        } else {
            employees.forEach(System.out::println);
        }
    }
}
