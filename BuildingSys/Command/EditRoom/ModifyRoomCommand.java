package Command.EditRoom;

import java.util.ArrayList;

import Building.Building;

public class ModifyRoomCommand extends EditRoomCommand {

    public ModifyRoomCommand(ArrayList<Building> buildingRecord, int id, int roomNo, double length, double width) {
        super(buildingRecord, id, roomNo);
        this.length = length;
        this.width = width;
    }

    @Override
    public void execute() {
        myBuilding.modifyRoom(roomNo, length, width);
    }

    @Override
    public String toString() {
        return "Modify Room: " + super.toString();
    }

}
