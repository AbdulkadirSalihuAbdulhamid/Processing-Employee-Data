package staff;

public class Manager extends Employee {
    private double basicWage; // Monthly basic wage in dollars
    private double managerOvertimeWage; // Hourly overtime wage for managers in dollars

    public Manager(int identifier, String name, int requiredWorkHours, double basicWage, double managerOvertimeWage) {
        super(identifier, name, "Manager", requiredWorkHours, basicWage, managerOvertimeWage);
        this.basicWage = basicWage;
        this.managerOvertimeWage = managerOvertimeWage;
    }

    public double getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(double basicWage) {
        this.basicWage = basicWage;
    }

    public double getManagerOvertimeWage() {
        return managerOvertimeWage;
    }

    public void setManagerOvertimeWage(double managerOvertimeWage) {
        this.managerOvertimeWage = managerOvertimeWage;
    }

    @Override
    public double calculateWage() {
        return basicWage + (getOvertimeHours() * managerOvertimeWage);
    }
}
