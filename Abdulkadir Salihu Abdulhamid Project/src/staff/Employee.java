package staff;


// Employee class

public class Employee {
    private int identifier;
    private String name;
    private String position;
    private int requiredWorkHours;
    private double wage;
    private double overtimeWage;
    private double sumWorkHours;
    private double missedHours;
    private double overtimeHours;

    public Employee(int identifier, String name, String position, int requiredWorkHours, double wage, double overtimeWage) {
        this.identifier = identifier;
        this.name = name;
        this.position = position;
        this.requiredWorkHours = requiredWorkHours;
        this.wage = wage;
        this.overtimeWage = overtimeWage;
        this.sumWorkHours = 0;
        this.missedHours = 0;
        this.overtimeHours = 0;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRequiredWorkHours() {
        return requiredWorkHours;
    }

    public void setRequiredWorkHours(int requiredWorkHours) {
        this.requiredWorkHours = requiredWorkHours;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getOvertimeWage() {
        return overtimeWage;
    }

    public void setOvertimeWage(double overtimeWage) {
        this.overtimeWage = overtimeWage;
    }

    public double getSumWorkHours() {
        return sumWorkHours;
    }

    public void setSumWorkHours(double sumWorkHours) {
        this.sumWorkHours = sumWorkHours;
    }

    public double getMissedHours() {
        return missedHours;
    }

    public void setMissedHours(double missedHours) {
        this.missedHours = missedHours;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public void recordDailyWorkHours(double hoursWorked) {
        if (hoursWorked <= requiredWorkHours) {
            sumWorkHours += hoursWorked;
        } else {
            sumWorkHours += requiredWorkHours;
            overtimeHours += hoursWorked - requiredWorkHours;
        }
        if (hoursWorked < requiredWorkHours) {
            missedHours += requiredWorkHours - hoursWorked;
        }
    }

    public double calculateWage() {
        if ("Manager".equalsIgnoreCase(position)) {
            return wage + (overtimeHours * overtimeWage);
        } else if ("Worker".equalsIgnoreCase(position)) {
            return (requiredWorkHours * wage) + (overtimeHours * wage * (1 + (overtimeWage / 100)));
        }
        return 0; // Handle other positions as needed
    }
}