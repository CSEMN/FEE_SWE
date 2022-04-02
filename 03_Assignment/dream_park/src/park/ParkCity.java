package park;

import java.util.ArrayList;

import utilities.Generate;

public class ParkCity {
    private String pc_id;
    private String cityName;
    private String location;
    private ArrayList<Game> games;

    private ParkCity() {
        this.pc_id = Generate.id("PkCty");
        this.games = new ArrayList<Game>();
    }

    public ParkCity(String cityName) {
        this();
        this.cityName = cityName;
        this.location = "North";
    }

    public String getPc_id() {
        return this.pc_id;
    }

    public void setPc_id(String pc_id) {
        this.pc_id = pc_id;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLoc() {
        return this.location;
    }

    public void setLoc(String location) {
        this.location = location;
    }

    public ArrayList<Game> getGames() {
        return this.games;
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public void displayGames() {
        
        Generate.printDashes(80);
        System.out.printf("%8s | %-15s | %-6s | %-7s | %-30s |\n",
                        "GID","Game Name","Price","Min Age","Game Manager");
        Generate.printDashes(80);

        for (Game g : getGames()){
            System.out.printf("%8s | %-15s | %05.2f  | %7d | %-30s |\n",
            g.getG_id(),g.getGName(),g.getPrice(),g.getAgeRestriction(),g.getGameManager().getName());
        }

        Generate.printDashes(80);

    }

}
