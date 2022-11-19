package Factories;

import java.util.ArrayList;
import java.util.Scanner;

import Building.Building;
import Command.*;
import Command.EditRoom.AddRoomsCommand;
import Command.EditRoom.DeleteRoomsCommand;
import Command.EditRoom.ModifyRoomCommand;
import Memento.*;

public class EditRoomFactory implements CommandFactory {
    private Scanner sc;
    private ArrayList<Building> buildingRecord;
    private Caretaker caretaker;
    private int roomNo;
    private Building myBuilding;
    private double length;
    private double width;
    private int buildingId;

    public EditRoomFactory(ArrayList<Building> buildingRecord, Caretaker caretaker) {
        this.buildingRecord = buildingRecord;
        this.caretaker = caretaker;
        this.sc = Main.BuildingSys.sc;
    }

    @Override
    public void create() throws Exception {
        System.out.print("Enter Building No.:");
        buildingId = sc.nextInt();

        // check if the user input id which is not exist
        if (buildingRecord.stream().filter(x -> x.getId() == buildingId).count() == 0) {
            System.out.print("The building no. does not exist!");
            return;
        }

        new DisplayBuildingCommand(buildingRecord, buildingId).execute();

        System.out.println("\nPlease enter command: [a|d|m]");
        System.out.println("a = add room, d = delete room, m = modify room");
        sc.nextLine();
        String command = sc.nextLine();

        myBuilding = buildingRecord.stream().filter(x -> x.getId() == buildingId).findFirst().get();

        Command myCommand;
        // userInputWidthHeight() and userInputRoomNumber() allow the user input
        // variable, if the format incorrect, return
        if (command.equals("a") && userInputWidthHeight())
            myCommand = new AddRoomsCommand(buildingRecord, buildingId, myBuilding.getRoomQty() + 1, length, width);
        else if (command.equals("d") && userInputRoomNumber())
            myCommand = new DeleteRoomsCommand(buildingRecord, buildingId, roomNo);
        else if (command.equals("m") && userInputRoomNumber() && userInputWidthHeight())
            myCommand = new ModifyRoomCommand(buildingRecord, buildingId, roomNo, length, width);
        else {
            System.out.println("input incorrect, please try again!");
            return;
        }

        caretaker.addElementToUndoList(myBuilding, myCommand);
        myCommand.execute();
        System.out.println("Updated Building:");
        new DisplayBuildingCommand(buildingRecord, buildingId).execute();
    }

    protected boolean userInputWidthHeight() {
        System.out.print("Length: ");
        length = sc.nextDouble();
        System.out.print("Width: ");
        width = sc.nextDouble();
        if (length < 0 || width < 0) {
            System.out.println("Height or Width must be greater than zero!");
            return false;
        }
        return true;
    }

    protected boolean userInputRoomNumber() {
        System.out.println("Room No.:");
        roomNo = sc.nextInt();
        // check room number is exist
        if (myBuilding.getRoomQty() < roomNo || roomNo <= 0) {
            System.out.println("The room no. does not exist!");
            return false;
        }
        return true;
    }

}
