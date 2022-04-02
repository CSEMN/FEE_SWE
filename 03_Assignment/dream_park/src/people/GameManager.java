package people;
import java.time.LocalDate;
import java.util.Random;

import utilities.Generate;
import park.ParkCity;

public class GameManager extends StaffMember {
    private int gameHandelCounter;

    public GameManager(ParkCity workLoc) {
        super(Generate.money(2000.0, 4000.0), workLoc);
        this.gameHandelCounter=new Random().nextInt(1000)+300;
    }

    public GameManager(String fullName, LocalDate dateOfBirth, double baseSalary, ParkCity workLoc) {
        super(fullName, dateOfBirth, baseSalary, workLoc);
        this.gameHandelCounter=0;
    }


    public double calcBonus() {
        double bonusRatio = 0.0002;
        double bonusRate = bonusRatio * getBaseSalary();
        return bonusRate * getGameHandelCounter();
    }

    @Override
    public double getTotalSalary() {
        return getBaseSalary() + calcBonus();
    }

    public int getGameHandelCounter() {
        return gameHandelCounter;
    }

    public void updateGameHandelCounter(int gameHandelCounter) {
        this.gameHandelCounter += gameHandelCounter;
    }

}
