package Factories.UndoRedo;

import Command.UndoRedo.UndoCommand;
import Factories.CommandFactory;
import Memento.*;

public class UndoFactory implements CommandFactory {
    private Caretaker caretaker;

    public UndoFactory(Caretaker caretaker){
        this.caretaker = caretaker;
    }

    @Override
    public void create() throws Exception {
        new UndoCommand(caretaker).execute();
    }

}