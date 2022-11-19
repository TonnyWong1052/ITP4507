package Factories.UndoRedo;

import Command.UndoRedo.ListRedoUndoCommand;
import Factories.CommandFactory;
import Memento.Caretaker;

public class ListRedoUndoFactory implements CommandFactory{
    private Caretaker caretaker;

    public ListRedoUndoFactory(Caretaker caretaker){
        this.caretaker = caretaker;
    }

    @Override
    public void create() throws Exception {
        new ListRedoUndoCommand(caretaker).execute();
    }
    
}
