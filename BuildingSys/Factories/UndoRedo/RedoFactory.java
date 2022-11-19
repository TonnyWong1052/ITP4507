package Factories.UndoRedo;

import Command.UndoRedo.RedoCommand;
import Factories.CommandFactory;
import Memento.Caretaker;

public class RedoFactory implements CommandFactory{
    private Caretaker caretaker;

    public RedoFactory(Caretaker caretaker){
        this.caretaker = caretaker;
    }

    @Override
    public void create() throws Exception {
        new RedoCommand(caretaker).execute();
    }
    
}
