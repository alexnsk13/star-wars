package ru.alexnsk.starwars.command.rotate;

import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.Endable;
import ru.alexnsk.starwars.model.UObject;

public class RotateEndable implements Endable {

    private final UObject object;
    private final Command moveCommand;

    public RotateEndable(UObject object, Command moveCommand) {
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