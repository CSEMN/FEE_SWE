package people;

import java.time.LocalDate;

import utilities.Generate;
import park.Game;
import park.ParkCard;

public class Visitor extends Human {
    private String v_id;
    private ParkCard parkCard;

    public Visitor() {
        super(Generate.date(1990, 2015));
        this.v_id = Generate.id("V");
        this.parkCard = new ParkCard();
    }

    public Visitor(String fullName, LocalDate dateOfBirth) {
        super(fullName, dateOfBirth);
        this.parkCard = new ParkCard();
    }

    public String getV_id() {
        return this.v_id;
    }

    public ParkCard getParkCard() {
        return this.parkCard;
    }

    public void setParkCard(ParkCard parkCard) {
        this.parkCard = parkCard;
    }

    public void buy(Seller seller, double price) {
        if (this.parkCard.getBalance() < price) {
            System.out.println("Insufficient Balance : " + getName());
            return;
        } else {
            this.parkCard.updateBalance(-1 * price);
            seller.updateSales(price); // Tightly coupled !
        }

    }

    public void useGame(Game game) {
        this.parkCard.updateBalance(-1 * game.getPrice());
        game.getGameManager().updateGameHandelCounter(1); // Tightly coupled !
    }

}
