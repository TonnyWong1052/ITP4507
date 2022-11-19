package Factories.CreateBuilding;


import Memento.Caretaker;

import java.util.ArrayList;

import Building.Building;
import Command.Command;
import Command.DisplayBuildingCommand;
import Command.AddBuilding.AddHouseCommand;

public class CreateHouseFactory extends CreateBuildingFactory {
    private int noOfFloors;

    public CreateHouseFactory(ArrayList<Building> buildingRecord, int id, Caretaker caretaker) {
        super(buildingRecord, caretaker);
        this.id = id;
    }

    @Override
    public void create() throws Exception {
        System.out.print("No. of Floors: ");
        noOfFloors = sc.nextInt();

        super.establishRooms();

        Command myCommand = new AddHouseCommand(buildingRecord, id, rooms, noOfFloors);
        myCommand.execute();
        System.out.println("New Building Added:");
        new DisplayBuildingCommand(buildingRecord, id).execute();
        addBuildingToUndoList(myCommand);
    }

}
