package Command.AddBuilding;

import java.util.ArrayList;

import Building.Apartment;
import Building.Building;
import Building.Room;

public class AddApartmentCommand extends AddBuildingCommand {
    private double monthlyRental;
    private String supportStaff;

    public AddApartmentCommand(ArrayList<Building> buildingRecord, int id,
            ArrayList<Room> rooms, double monthlyRental, String supportStaff) {
        super(buildingRecord, id, rooms);
        this.monthlyRental = monthlyRental;
        this.supportStaff = supportStaff;
    }

    @Override
    public void execute() {
        addRoomToElement(new Apartment(id, rooms.size(), monthlyRental, supportStaff));
        buildingRecord.add(myBuilding);
    }

    @Override
    public String toString(){
        return super.toString() + new Apartment(id, rooms.size(), monthlyRental, supportStaff);
    }

}
