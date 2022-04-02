package people;
import java.time.LocalDate;
import java.util.Random;

import utilities.Generate;
import park.ParkCity;

public class Dustman extends StaffMember {
    private int roundParticipated;

    public Dustman(ParkCity workLoc) {
        super(Generate.money(1500.0, 2500.0), workLoc);

        this.roundParticipated = new Random().nextInt(300) + 10;
    }

    public Dustman(String fullName, LocalDate dateOfBirth, double baseSalary, ParkCity workLoc) {
        super(fullName, dateOfBirth, baseSalary, workLoc);
        this.roundParticipated = 0;
    }

    @Override
    public double getTotalSalary() {
        double roundTip = 2.00;// EGP
        return getBaseSalary() + roundTip * getRounds();
    }

    public int getRounds() {
        return roundParticipated;
    }

    public void updateRounds(int rounds) {
        this.roundParticipated += rounds;
    }

}
