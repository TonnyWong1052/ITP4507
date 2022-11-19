package Command;

import java.util.ArrayList;

import Building.Building;

public class DisplayAllBuildingCommand implements Command {
    private ArrayList<Building> buildingRecord;

    public DisplayAllBuildingCommand(ArrayList<Building> buildingRecord){
        this.buildingRecord = buildingRecord;
    }

    @Override
    public void execute() {
        //check building no. exist or not
        if(buildingRecord.size()==0)
            System.out.println("Data not found");
        else{
            for (Building record : buildingRecord)
                System.out.println(record);
        }
    }
}
