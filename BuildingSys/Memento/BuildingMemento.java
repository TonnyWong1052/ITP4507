package Memento;

import java.util.ArrayList;

import Building.Building;
import Building.Room;
import Command.Command;

public abstract class BuildingMemento {
    protected Command myCommand;
    protected Building myBuilding;
    protected int buildingId;
    protected ArrayList<Room> myRoom;

    public BuildingMemento(Command myCommand, Building building) {
        this.myCommand = myCommand;
        this.myBuilding = building;
        this.buildingId = building.getId();
        myRoom = new ArrayList<>();
        myRoom = cloneRoomObject(building.getRooms());
    }

    public abstract void restore();

    public Command getCommand() {
        return myCommand;
    }

    private ArrayList<Room> cloneRoomObject(ArrayList<Room> tempRoom) {
        ArrayList<Room> returnRoom = new ArrayList<>();
        for (int x = 0; x < tempRoom.size(); x++) {
            Room room = tempRoom.get(x);
            returnRoom.add(new Room(room.getLength(), room.getWidth()));
        }
        return returnRoom;
    }

    protected void restoreRooms(Building building) {
        building.setRooms(cloneRoomObject(myRoom));
    }

}