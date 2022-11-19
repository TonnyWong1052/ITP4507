package Command.AddBuilding;

import java.util.ArrayList;

import Building.Building;
import Building.Room;
import Command.Command;

public abstract class AddBuildingCommand implements Command {
    protected ArrayList<Building> buildingRecord;
    protected int id;
    protected ArrayList<Room> rooms;
    protected Building myBuilding;

    public AddBuildingCommand(ArrayList<Building> buildingRecord, int id, ArrayList<Room> rooms){
        this.buildingRecord = buildingRecord;
        this.id = id;
        this.rooms = rooms;
    }

    @Override
    public abstract void execute();

    protected void addRoomToElement(Building myBuilding){
        for(int x=0;x<rooms.size();x++){
            Room room = rooms.get(x);
            myBuilding.addRoom(room.getLength(), room.getWidth());
        }
        this.myBuilding = myBuilding;
    }

    @Override
    public String toString(){
        return "Add Building: ";
    }
}
