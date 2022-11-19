package Memento;

import java.util.Stack;

import Building.Apartment;
import Building.Building;
import Building.House;
import Command.Command;

public class Caretaker {
    private Stack<BuildingMemento> undoList;
    private Stack<BuildingMemento> redoList;

    public Caretaker() {
        undoList = new Stack<>();
        redoList = new Stack<>();
    }

    public void addElementToUndoList(Building mybuilding, Command myCommand) {
        if (mybuilding instanceof Apartment)
            undoList.push(new ApartmentMemento(myCommand, (Apartment) mybuilding));
        else if (mybuilding instanceof House)
            undoList.push(new HouseMemento(myCommand, (House) mybuilding));
        else// for debug only
            System.out.println("System error!");
    }

    public void showAllRedoUndoList() {
        System.out.println("Undo List:");
        if (undoList.empty())
            System.out.println("Nothing to Undo");
        else
            for (int x = undoList.size() - 1; x >= 0; x--)
                System.out.println(undoList.get(x).getCommand());

        System.out.println("Redo List:");
        if (redoList.empty())
            System.out.println("Nothing to Redo");
        else
            for (int x = redoList.size() - 1; x >= 0; x--)
                System.out.println(redoList.get(x).getCommand());

    }

    public void undo() {
        if (undoList.isEmpty()) {
            System.out.println("Nothing to Undo!");
        } else {
            BuildingMemento memento = undoList.pop();
            redoList.add(memento);
            memento.restore();
        }
    }

    public void redo() {
        if (redoList.isEmpty()) {
            System.out.println("Nothing to Redo!");
        } else {
            BuildingMemento memento = redoList.pop();
            memento.getCommand().execute();
            undoList.push(memento);
        }
    }

}