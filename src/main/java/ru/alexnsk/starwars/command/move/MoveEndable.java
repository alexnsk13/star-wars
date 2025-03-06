package ru.alexnsk.starwars.command.move;

import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.Endable;
import ru.alexnsk.starwars.model.UObject;

public class MoveEndable implements Endable {

    private final UObject object;
    private final Command moveCommand;

    public MoveEndable(UObject object, Command moveCommand) {
        this.object = object;
        this.moveCommand = moveCommand;
    }

    @Override
    public Command getCommand() {
        return moveCommand;
    }

    @Override
    public UObject getObject() {
        return object;
    }
}
