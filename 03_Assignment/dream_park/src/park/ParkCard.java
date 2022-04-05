package park;

import utilities.Generate;

public class ParkCard {
    private String pc_id;
    private double balance;

    public ParkCard() {
        this.pc_id = Generate.id("CARD");
        this.balance = Generate.money(50.0, 200.0);
    }

    public ParkCard(double balance) {
        this.balance = balance;
    }

    public String getPc_id() {
        return this.pc_id;
    }

    public void setPc_id(String pc_id) {
        this.pc_id = pc_id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void updateBalance(double balance) {
        this.balance += balance;
    }

}
