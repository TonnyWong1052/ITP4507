package Command.ModifyBuilding;

import java.util.ArrayList;

import Building.Building;
import Command.Command;


public abstract class ModifyBuildingCommand implements Command {
    protected int id;
    protected ArrayList<Building> buildingRecord;
    protected Building myBuilding;

    public ModifyBuildingCommand(int id, ArrayList<Building> buildingRecord){
        this.id = id;
        this.buildingRecord = buildingRecord;
        //find the building which building id is match variable called id 
        myBuilding = buildingRecord.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public abstract void execute();

    @Override
    public String toString(){
        return "Modify Building: Building No.: " + id;
    }
    
}
