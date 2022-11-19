package Factories.ModifyBuilding;

import java.util.ArrayList;

import Building.Building;
import Command.Command;
import Command.ModifyBuilding.ModifyHouseCommand;
import Memento.Caretaker;

public class ModifyHouseFactory extends ModifyBuildingFactory {
    private int noOfFloors;

    public ModifyHouseFactory(ArrayList<Building> buildingRecord, Caretaker caretaker, int buildingId, Building mybuilding) {
        super(buildingRecord, caretaker);
        this.buildingId = buildingId;
        this.myBuilding = mybuilding;
    }

    @Override
    public void create() throws Exception {
        System.out.print("No of Floors: ");
        noOfFloors = sc.nextInt();
        Command myCommand = new ModifyHouseCommand(buildingId, buildingRecord, noOfFloors);
        myCommand.execute();
        caretaker.addElementToUndoList(myBuilding, myCommand);
        printUpdateBuilding();
    }

}
