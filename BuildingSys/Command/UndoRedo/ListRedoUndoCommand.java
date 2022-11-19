package Command.UndoRedo;

import Command.Command;
import Memento.Caretaker;

public class ListRedoUndoCommand implements Command {
    private Caretaker caretaker;

    public ListRedoUndoCommand(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        caretaker.showAllRedoUndoList();
    }

}