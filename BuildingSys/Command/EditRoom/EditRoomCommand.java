package Command.EditRoom;

import java.util.ArrayList;

import Building.Building;
import Building.Room;
import Command.Command;

public abstract class EditRoomCommand implements Command{
    protected int id;
    protected ArrayList<Building> buildingRecord;
    protected Building myBuilding;
    protected double length;
    protected double width;
    protected int roomNo;
    
    public EditRoomCommand(ArrayList<Building> buildingRecord, int id, int roomNo){
        this.buildingRecord = buildingRecord;
        this.id = id;
        this.roomNo = roomNo;
        //find the building which building id is match variable called id 
        this.myBuilding = buildingRecord.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    public String toString(){
        return "Building No. " + id + ", Room No. " +  roomNo + ", " + new Room(length, width);
    }
}