package staff;

public class Worker extends Employee {
    private double hourlyWage; // Hourly wage in dollars
    private double overtimeWagePercentage; // Overtime wage as a percentage

    public Worker(int identifier, String name, int requiredWorkHours, double hourlyWage, double overtimeWagePercentage) {
        super(identifier, name, "Worker", requiredWorkHours, hourlyWage, overtimeWagePercentage);
        this.hourlyWage = hourlyWage;
        this.overtimeWagePercentage = overtimeWagePercentage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getOvertimeWagePercentage() {
        return overtimeWagePercentage;
    }

    public void setOvertimeWagePercentage(double overtimeWagePercentage) {
        this.overtimeWagePercentage = overtimeWagePercentage;
    }

    @Override
    public double calculateWage() {
        double regularWage = getSumWorkHours() * hourlyWage;
        double overtimeWage = getOvertimeHours() * hourlyWage * (1 + (overtimeWagePercentage / 100));
        return regularWage + overtimeWage;
    }
}