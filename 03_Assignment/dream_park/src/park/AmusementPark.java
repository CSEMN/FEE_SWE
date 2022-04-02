package park;
import java.util.ArrayList;

import utilities.Generate;

public class AmusementPark {
    private String ap_id;
    private String parkName;
    private String address;
    private ArrayList<ParkCity> divisions;

    public AmusementPark() {
        divisions = new ArrayList<ParkCity>();
        this.ap_id = Generate.id("AmPk");
    }

    public AmusementPark(String parkName) {
        this();
        this.parkName = parkName;
        this.address = "Cairo";
    }

    public String getAp_id() {
        return this.ap_id;
    }

    public void setAp_id(String ap_id) {
        this.ap_id = ap_id;
    }

    public String getName() {
        return this.parkName;
    }

    public void setName(String parkName) {
        this.parkName = parkName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<ParkCity> getDivisions() {
        return this.divisions;
    }

    public void addDivision(ParkCity division) {
        this.divisions.add(division);
    }

    public void displayDivisions() {
        int counter=0;
        System.out.println(getName()+ " Divisions");
        for (ParkCity pc : getDivisions()){
            System.out.println(++counter + " : "+ pc.getCityName()+", "+pc.getLoc());
        }
    }

}
