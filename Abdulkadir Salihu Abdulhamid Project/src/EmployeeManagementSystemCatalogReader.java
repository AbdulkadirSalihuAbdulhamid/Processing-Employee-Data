import staff.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystemCatalogReader {
    public List<Employee> readCatalogFile(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 6) {
                    int identifier = Integer.parseInt(data[0]);
                    String name = data[1];
                    String position = data[2];
                    int requiredWorkHours = Integer.parseInt(data[3]);
                    double wage = Double.parseDouble(data[4]);
                    double overtimeWage = Double.parseDouble(data[5]);

                    Employee employee = new Employee(identifier, name, position, requiredWorkHours, wage, overtimeWage);
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}

