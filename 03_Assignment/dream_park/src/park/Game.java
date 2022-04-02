package park;

import utilities.Generate;
import people.GameManager;

public class Game {
    private String g_id;
    private String gName;
    private double price;
    private int ageRestriction;
    private String description;
    private GameManager gameManager;

    public Game(String gName, GameManager gameManager) {
        this.g_id=Generate.id("G");
        this.gName = gName;
        this.price = Generate.money(5.0, 50.0);
        this.ageRestriction= Generate.integer(7, 18);
        this.gameManager = gameManager;
    }

    public Game(String gName, double price, GameManager gameManager) {
        this.gName = gName;
        this.price = price;
        this.gameManager = gameManager;
    }

    public String getG_id() {
        return this.g_id;
    }

    public String getGName() {
        return this.gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAgeRestriction() {
        return this.ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GameManager getGameManager() {
        return this.gameManager;
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

}
