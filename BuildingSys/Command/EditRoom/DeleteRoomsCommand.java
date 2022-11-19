package Command.EditRoom;

import java.util.ArrayList;

import Building.Building;

public class DeleteRoomsCommand extends EditRoomCommand {

    public DeleteRoomsCommand(ArrayList<Building> buildingRecord, int id, int roomNo){
        super(buildingRecord, id, roomNo);
        length = myBuilding.getRooms().get(roomNo-1).getLength();
        width = myBuilding.getRooms().get(roomNo-1).getWidth();
    }

    @Override
    public void execute() {
        myBuilding.deleteRoom(roomNo);
    }

    @Override
    public String toString(){
        return "Delete Room: " + super.toString();
    }

}
