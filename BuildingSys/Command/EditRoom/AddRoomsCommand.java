package Command.EditRoom;

import java.util.ArrayList;

import Building.Building;

public class AddRoomsCommand extends EditRoomCommand {

    public AddRoomsCommand(ArrayList<Building> buildingRecord, int id, int roomNo, double length, double width){
        super(buildingRecord, id, roomNo);
        this.length = length;
        this.width = width;
    }

    @Override
    public void execute() {
        myBuilding.addRoom(length, width);
    }

    @Override
    public String toString(){
        return "Add Room: " + super.toString();
    }

}
