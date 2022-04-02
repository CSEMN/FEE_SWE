package people;
import java.time.LocalDate;
import java.time.Period;

import utilities.Generate;

public abstract class Human {
    private String id;
    private String fullName;
    private LocalDate dateOfBirth;

    public Human(LocalDate dateOfBirth) {
        this.id = Generate.id("H");
        this.fullName = Generate.fullName();
        this.dateOfBirth = dateOfBirth;
    }
    public Human(String fullName, LocalDate dateOfBirth) {
        this.id = Generate.id("H");
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.fullName;
    }

    public void setName(String fullName) {
        this.fullName = fullName;
    }

    public void setDOB(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(){
        LocalDate now = LocalDate.now(); 
        return Period.between(this.dateOfBirth, now).getYears();
    }

}
