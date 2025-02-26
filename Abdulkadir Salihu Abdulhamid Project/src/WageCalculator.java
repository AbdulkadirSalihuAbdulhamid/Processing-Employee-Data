import staff.Employee;

import java.util.List;

public class WageCalculator {
    public void calculateWages(List<Employee> employees, List<WorkHoursCatalog> dailyWorkRecords) {
        for (WorkHoursCatalog record : dailyWorkRecords) {
            for (Employee employee : employees) {
                if (employee.getIdentifier() == record.getIdentifier()) {
                    employee.recordDailyWorkHours(record.getHoursWorked());
                }
            }
        }
    }
}