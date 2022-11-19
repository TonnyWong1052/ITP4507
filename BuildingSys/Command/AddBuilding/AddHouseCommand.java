package Command.AddBuilding;

import java.util.ArrayList;

import Building.Building;
import Building.House;
import Building.Room;

public class AddHouseCommand extends AddBuildingCommand {
    private int noOfFloors;

    public AddHouseCommand(ArrayList<Building> buildingRecord, int id, ArrayList<Room> rooms, int noOfFloors) {
        super(buildingRecord, id, rooms);
        this.noOfFloors = noOfFloors;
    }

    @Override
    public void execute() {
        addRoomToElement(new House(id, rooms.size(), noOfFloors));
        buildingRecord.add(myBuilding);
    }

    @Override
    public String toString(){
        return super.toString() + new House(id, rooms.size(), noOfFloors);
    }

}
