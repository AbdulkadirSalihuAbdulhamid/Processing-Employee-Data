public class WorkHoursCatalog {
    private int identifier;
    private double hoursWorked;

    public WorkHoursCatalog(int identifier, double hoursWorked) {
        this.identifier = identifier;
        this.hoursWorked = hoursWorked;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}