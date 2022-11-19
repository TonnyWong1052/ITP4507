package Command.ModifyBuilding;

import java.util.ArrayList;

import Building.Apartment;
import Building.Building;

public class ModifyApartmentCommand extends ModifyBuildingCommand {
    private double monthlyRental;
    private String supportStaff;

    public ModifyApartmentCommand(ArrayList<Building> buildingRecord, int id, double monthlyRental, String supportStaff) {
        super(id, buildingRecord);
        this.monthlyRental = monthlyRental;
        this.supportStaff = supportStaff;
    }

    @Override
    public void execute() {
        ((Apartment)myBuilding).setMonthlyRental(monthlyRental);
        ((Apartment)myBuilding).setSupportStaff(supportStaff);
    }

    @Override
    public String toString(){
        return super.toString() + ", Support Staff: " + supportStaff + ", Monthly Rental: " + monthlyRental;
    }

}
