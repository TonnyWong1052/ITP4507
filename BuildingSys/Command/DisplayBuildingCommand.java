package Command;

import java.util.ArrayList;
import java.util.stream.Collectors;

import Building.Building;

public class DisplayBuildingCommand implements Command {
    private ArrayList<Building> buildingRecord;
    private int buildingId;

    public DisplayBuildingCommand(ArrayList<Building> buildingRecord, int buildingId) {
        this.buildingRecord = buildingRecord;
        this.buildingId = buildingId;
    }

    @Override
    public void execute() {       
        //find the building no. which match the variable called id 
        ArrayList<Building> myBuilding = (ArrayList<Building>) buildingRecord.stream().filter(s -> s.getId() == buildingId)
                .collect(Collectors.toList());
        //check building no. exist or not
        if (myBuilding.size() == 0)
            System.out.println("Data not found");
        else
            myBuilding.get(0).printBuilding();
    }
}
