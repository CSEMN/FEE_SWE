import java.util.ArrayList;

import park.AmusementPark;
import park.Game;
import park.ParkCity;
import people.GameManager;
import people.Seller;
import people.Visitor;
import utilities.Generate;

public class Main {
    private static ArrayList<Visitor>visitorsList = new ArrayList<Visitor>();
    private static ArrayList<Seller>sellersList = new ArrayList<Seller>();
    public static void main(String[] args) throws Exception {
        AmusementPark dreamPark = new AmusementPark("Dream Park");
        generateParkCities(dreamPark);
        generateGames(dreamPark);
        dreamPark.displayDivisions();
        printAllGames(dreamPark);
        generateVisitors();
        displayVisitors();
        generateSellers(dreamPark);
        displaySellers();
        visitorsPurchase();
        displayVisitors();
        displaySellers();
    }

    public static void generateParkCities(AmusementPark park) {
        ParkCity parkCity = new ParkCity("Horror City");
        park.addDivision(parkCity);
        parkCity = new ParkCity("Adventure City");
        park.addDivision(parkCity);
        parkCity = new ParkCity("Disney City");
        park.addDivision(parkCity);
        parkCity = new ParkCity("Water City");
        park.addDivision(parkCity);

    }

    public static void generateGames(AmusementPark park){
        for (ParkCity pc : park.getDivisions()){
            for (int i=1;i<=5;i++){
                GameManager gm=new GameManager(pc);
                Game game=new Game("Game "+Generate.integer(1, 100),gm);
                pc.addGame(game);
            }
        }
    }

    public static void printAllGames(AmusementPark park){
        for (ParkCity pc : park.getDivisions()){
            System.out.println();
            Generate.printDashes(22);
            System.out.printf("%-20s |\n",pc.getCityName() +" Games" );
            pc.displayGames();
        }    
    }

    public static void generateVisitors(){
        for (int i=0;i<5;i++){
            visitorsList.add(new Visitor());
        }
    }

    public static void displayVisitors(){
        Generate.printDashes(61);
        System.out.printf("%8s | %8s | %-20s | %4s | %7s |\n",
                        "VID","CardID","Visitor Name","Age","Balance");
        Generate.printDashes(61);

        for(Visitor v : visitorsList){
            System.out.printf("%8s | %8s | %-20s | %4d | %07.2f |\n",
                                v.getV_id(),v.getParkCard().getPc_id(),v.getName(),v.getAge(),v.getParkCard().getBalance());
        }
        Generate.printDashes(61);
    }

    public static void generateSellers(AmusementPark park){
        for (int i=0;i<5;i++){
            sellersList.add(new Seller(park.getDivisions().get(Generate.integer(0,4))));
        }
    }

    public static void displaySellers(){
        Generate.printDashes(81);
        System.out.printf("%8s | %-20s | %3s | %10s | %10s | %12s |\n",
                        "SID","Seller Name","Age","Base Salary","Commission","Total Salary");
        Generate.printDashes(81);

        for(Seller sl : sellersList){
            System.out.printf("%8s | %-20s | %3d | %11.2f | %10.2f | %12.2f |\n",
                            sl.getStaff_id(),sl.getName(),sl.getAge(),sl.getBaseSalary(),sl.calcCommission(),sl.getTotalSalary());
        }
        Generate.printDashes(80);
    }

    public static void visitorsPurchase(){
        for (int i=0 ; i<20;i++){
            visitorsList.get(Generate.integer(0, visitorsList.size())).
            buy(sellersList.get(Generate.integer(0, sellersList.size())),
            Generate.money(10.0, 50.0));
        }
        System.out.println("All Purchase process Completed !");
    }

}
