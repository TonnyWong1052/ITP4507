package Factories.CreateBuilding;

import java.util.ArrayList;
import java.util.Scanner;

import Building.Building;
import Building.Room;
import Command.Command;
import Factories.CommandFactory;
import Memento.Caretaker;

public class CreateBuildingFactory implements CommandFactory {
    protected int id;
    protected ArrayList<Room> rooms;
    protected Scanner sc;
    protected int NoOfRooms;
    protected ArrayList<Building> buildingRecord;
    protected Caretaker caretaker;

    public CreateBuildingFactory(ArrayList<Building> buildingRecord, Caretaker caretaker) {
        this.buildingRecord = buildingRecord;
        this.sc = Main.BuildingSys.sc;
        this.caretaker = caretaker;
        rooms = new ArrayList<>();
    }

    @Override
    public void create() throws Exception {
        // input the command to select the type of the building
        System.out.println("Enter Building Type (a=Apartment/h=House):");
        String command = sc.next();
        if (!command.equals("a") && !command.equals("h")) {
            System.out.println("Please input correct command");
            return;
        }

        System.out.print("Building No.: ");
        id = sc.nextInt();
        // check the no. is uniquery
        int size = buildingRecord.stream().filter(x -> x.getId() == id).toList().size();
        if (size >= 1) {
            System.out.println("This building no. is repeat, please input another building no.!");
            return;
        }

        // create new building object, a = apartment, h = house
        if (command.equals("a"))
            new CreateApartmentFactory(buildingRecord, id, caretaker).create();
        else if (command.equals("h"))
            new CreateHouseFactory(buildingRecord, id, caretaker).create();
    }

    protected void establishRooms() {
        // building up room
        System.out.print("Number of rooms: ");
        NoOfRooms = sc.nextInt();
        for (int x = 0; x < NoOfRooms; x++) {
            System.out.print("Room No. " + (x + 1) + " :");
            System.out.print("\nLength: ");
            double length = sc.nextDouble();
            System.out.print("Width: ");
            double width = sc.nextDouble();
            rooms.add(new Room(length, width));
        }
    }

    protected void printCurrentAllRooms() {
        for (int x = 0; x < rooms.size(); x++)
            System.out.println("Room No.: " + (x + 1) + rooms.get(x));
    }

    protected void addBuildingToUndoList(Command myCommand) {
        // for redo, undo record
        Building myBuilding = buildingRecord.stream().filter(x -> x.getId() == id).findFirst().get();
        caretaker.addElementToUndoList(myBuilding, myCommand);
    }

}
