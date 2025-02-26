import staff.Employee;
import staff.Manager;
import staff.Worker;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = getEmployeeList();

        // Print information about each employee
        for (Employee employee : employees) {
            System.out.printf("Here is the information regarding %s:%n" +
                            "Identifier: %s%n" +
                            "Required Work Hours: %s%n",
                    employee.getName(),
                    employee.getIdentifier(),
                    employee.getRequiredWorkHours());

            if (employee instanceof Worker worker) {
                System.out.printf("Hourly Wage: %s%n" +
                                "Overtime Wage Percentile: %s%%%n",
                        worker.getHourlyWage(),
                        worker.getOvertimeWagePercentage() * 100);
            }
        }

        // Sort employees by missed hours and name (Question 3)
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int missedHoursComparison = Double.compare(e1.getMissedHours(), e2.getMissedHours());
                if (missedHoursComparison != 0) {
                    return missedHoursComparison;
                }
                return e1.getName().compareTo(e2.getName());
            }
        });

        // Print current wages of employees in alphabetical order of employee name
        System.out.println("Current Wages of Employees (Alphabetical Order):");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": $" + employee.calculateWage());
        }

        // Sort employees by most missed hours and name (Question 4)
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int missedHoursComparison = Double.compare(e2.getMissedHours(), e1.getMissedHours());
                if (missedHoursComparison != 0) {
                    return missedHoursComparison;
                }
                return e1.getName().compareTo(e2.getName());
            }
        });

        // Print list of employees in order of most missed hours
        System.out.println("\nList of Employees (Most Missed Hours First):");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - Missed Hours: " + employee.getMissedHours());
        }
    }

    private static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        int numberOfEmployees = 8; // Change this to the number of employees you want

        String[] names = {"Kovacs", "AK", "Szolnay", "Andy", "Moses", "Eve", "Frank", "Mercy"};
        String[] positions = {"Worker", "Manager"};

        Random random = new Random();

        for (int i = 0; i < numberOfEmployees; i++) {
            String name = names[random.nextInt(names.length)];
            String position = positions[random.nextInt(positions.length)];

            int identifier = 1000 + i; // Generate unique identifier for each employee
            int requiredWorkHours = 8; // You can adjust this as needed

            double wage;
            double overtimeWage;

            if ("Manager".equalsIgnoreCase(position)) {
                wage = 3000 + random.nextInt(2000); // Random basic wage for managers
                overtimeWage = 20.0 + (random.nextDouble() * 10.0); // Random overtime wage for managers
            } else {
                wage = 15.0 + (random.nextDouble() * 10.0); // Random hourly wage for workers
                overtimeWage = 0.2 + (random.nextDouble() * 0.4); // Random overtime wage percentage for workers
            }

            // Create and add the employee to the list
            Employee employee;
            if ("Manager".equalsIgnoreCase(position)) {
                employee = new Manager(identifier, name, requiredWorkHours, wage, overtimeWage);
            } else {
                employee = new Worker(identifier, name, requiredWorkHours, wage, overtimeWage);
            }

            employees.add(employee);
        }
        return employees;
    }
}
