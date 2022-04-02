package people;
import java.time.LocalDate;

import utilities.Generate;
import park.ParkCity;

public abstract class StaffMember extends Human {
    private String staff_id;
    private double baseSalary;
    private ParkCity workLoc;
    
    public StaffMember(double baseSalary,ParkCity workLoc) {
    super(Generate.date(1970, 2000));
    this.staff_id = Generate.id("SM");
    this.baseSalary = baseSalary;
    this.workLoc = workLoc;
    }

    public StaffMember(String fullName, LocalDate dateOfBirth, double baseSalary, ParkCity workLoc) {
        super(fullName, dateOfBirth);
        this.staff_id = Generate.id("SM");
        this.baseSalary = baseSalary;
        this.workLoc = workLoc;
    }

    public String getStaff_id() {
        return this.staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    
    public ParkCity getDutyLoc() {
        return this.workLoc;
    }
    
    public void setDutyLoc(ParkCity workLoc) {
        this.workLoc = workLoc;
    }
    
    public abstract double getTotalSalary();
 
}
