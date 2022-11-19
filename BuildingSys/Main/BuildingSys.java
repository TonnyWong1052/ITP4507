package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Building.Building;
import Memento.Caretaker;
import Factories.*;
import Factories.CreateBuilding.CreateBuildingFactory;
import Factories.ModifyBuilding.ModifyBuildingFactory;
import Factories.UndoRedo.ListRedoUndoFactory;
import Factories.UndoRedo.RedoFactory;
import Factories.UndoRedo.UndoFactory;

public class BuildingSys {
    public static Scanner sc = new Scanner(System.in);
    private final static int addBuildingFactory = 0, displayAllBuildingRecordFactory = 1, modifyBuildingFactory = 2,
            editRoomsFactory = 3, undoFactory = 4, redoFactory = 5, listRedoUndoFactory = 6,
            exitSystemFactory = 7, emptyFactory = 8;

    public static void main(String[] args) throws Exception {
        ArrayList<Building> buildingRecord = new ArrayList<>();
        Caretaker caretaker = new Caretaker();

        CommandFactory[] factories = new CommandFactory[9];
        factories[0] = new CreateBuildingFactory(buildingRecord, caretaker);
        factories[1] = new DisplayBuildingFactory(buildingRecord);
        factories[2] = new ModifyBuildingFactory(buildingRecord, caretaker);
        factories[3] = new EditRoomFactory(buildingRecord, caretaker);
        factories[4] = new UndoFactory(caretaker);
        factories[5] = new RedoFactory(caretaker);
        factories[6] = new ListRedoUndoFactory(caretaker);
        factories[7] = new ExitSystemFactory();
        factories[8] = new ErrorInputFactory();

        while (true) {
            System.out.println("\nBuilding Management System (BMS)");
            System.out.println("Please enter command: [a|d|m|e|u|r|l|x]");
            System.out.println("a = add building, d = display buildings, m = modify building, e = edit rooms \nu = undo, r = redo, l = list undo/redo, x = exit system");
            int commandIndex = convertAlphabetToInt(sc.next());
            factories[commandIndex].create();
        }
    }

    private static int convertAlphabetToInt(String alphabet) {
        switch (alphabet) {
            case "a":
                return addBuildingFactory;
            case "d":
                return displayAllBuildingRecordFactory;
            case "m":
                return modifyBuildingFactory;
            case "e":
                return editRoomsFactory;
            case "u":
                return undoFactory;
            case "r":
                return redoFactory;
            case "l":
                return listRedoUndoFactory;
            case "x":
            case "X":
                return exitSystemFactory;
            default:
                return emptyFactory;
        }
    }
}