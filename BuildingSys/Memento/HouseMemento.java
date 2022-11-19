package Memento;

import Building.House;
import Command.Command;

public class HouseMemento extends BuildingMemento{
    private int noOfFloors;

    public HouseMemento( Command myCommand, House building) {
        super(myCommand, building);
        this.noOfFloors = building.getFloors();
    }

    @Override
    public void restore() {
        ((House) myBuilding).setFloors(noOfFloors);
        restoreRooms(myBuilding);
    }
    
}
