package Factories.CreateBuilding;

import java.util.ArrayList;

import Building.Building;
import Command.Command;
import Command.DisplayBuildingCommand;
import Command.AddBuilding.AddApartmentCommand;
import Memento.Caretaker;

public class CreateApartmentFactory extends CreateBuildingFactory {
    private double monthlyRental;
    private String supportStaff;

    public CreateApartmentFactory(ArrayList<Building> buildingRecord, int id, Caretaker caretaker) {
        super(buildingRecord, caretaker);
        this.id = id;
    }

    @Override
    public void create() throws Exception {
        System.out.print("Monthly Rental: ");
        monthlyRental = sc.nextDouble();
        sc.nextLine();
        System.out.print("Support Staff: ");
        supportStaff = sc.nextLine();

        //create room object
        super.establishRooms();

        Command myCommand = new AddApartmentCommand(buildingRecord, id, rooms, monthlyRental, supportStaff);
        myCommand.execute();

        //print new building message
        System.out.println("New Building Added:");
        new DisplayBuildingCommand(buildingRecord, id).execute();
        addBuildingToUndoList(myCommand);
    }
}