package Command.UndoRedo;

import Command.Command;
import Memento.*;

public class UndoCommand implements Command {
    private Caretaker caretaker;

    public UndoCommand(Caretaker caretaker){
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        caretaker.undo();
    }

}
