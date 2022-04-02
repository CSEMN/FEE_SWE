package people;
import java.time.LocalDate;

import utilities.Generate;
import park.ParkCity;

public class Seller extends StaffMember {
    private double totalSales;

    public Seller(ParkCity workLoc) {
        super(Generate.money(2000.0, 4500.0), workLoc);
        this.totalSales = Generate.money(300.0, 4000.0);
    }

    public Seller(String fullName, LocalDate dateOfBirth, double baseSalary, ParkCity workLoc) {
        super(fullName, dateOfBirth, baseSalary, workLoc);
    }

    public double calcCommission() {
        double commRatio = 0.03;
        return commRatio * getTotalSales();
    }

    @Override
    public double getTotalSalary() {
        return getBaseSalary() + calcCommission();
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void updateSales(double sales) {
        this.totalSales += sales;
    }

}
