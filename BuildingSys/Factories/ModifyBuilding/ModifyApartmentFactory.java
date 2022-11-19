package Factories.ModifyBuilding;

import java.util.ArrayList;

import Building.Building;
import Command.Command;
import Command.ModifyBuilding.ModifyApartmentCommand;
import Memento.Caretaker;

public class ModifyApartmentFactory extends ModifyBuildingFactory {
    private double monthlyRental;
    private String supportStaff;

    public ModifyApartmentFactory(ArrayList<Building> buildingRecord, Caretaker caretaker, int buildingId, Building myBuilding) {
        super(buildingRecord, caretaker);
        this.buildingId = buildingId;
        this.myBuilding = myBuilding;
    }

    @Override
    public void create() throws Exception {
        System.out.print("Modify Monthly Rental: ");
        monthlyRental = sc.nextDouble();
        System.out.print("Modify Support Staff: ");
        sc.nextLine();
        supportStaff = sc.nextLine();
        Command myCommand = new ModifyApartmentCommand(buildingRecord, buildingId, monthlyRental, supportStaff);
        myCommand.execute();
        caretaker.addElementToUndoList(myBuilding, myCommand);
        printUpdateBuilding();
    }

}
