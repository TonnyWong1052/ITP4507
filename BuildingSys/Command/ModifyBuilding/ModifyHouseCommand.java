package Command.ModifyBuilding;

import java.util.ArrayList;

import Building.Building;
import Building.House;

public class ModifyHouseCommand extends ModifyBuildingCommand{
    private int noOfFloors;

    public ModifyHouseCommand(int id, ArrayList<Building> buildingRecord, int noOfFloors) {
        super(id, buildingRecord);
        this.noOfFloors = noOfFloors;
    }

    @Override
    public void execute() {
        ((House)myBuilding).setFloors(noOfFloors);
    }

    @Override
    public String toString(){
        return super.toString() + ", No. of Floor: " + noOfFloors;
    }
    
}
