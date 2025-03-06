package ru.alexnsk.starwars.command.rotate;

import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.Endable;
import ru.alexnsk.starwars.model.UObject;

import java.util.Queue;

public class RotateEndable implements Endable {

    private final UObject object;
    private final Command moveCommand;
    private final Queue<Command> commandQueue;

    public RotateEndable(UObject object, Command moveCommand, Queue<Command> commandQueue) {
        this.object = object;
        this.moveCommand = moveCommand;
        this.commandQueue = commandQueue;
    }

    @Override
    public Command getCommand() {
        return moveCommand;
    }

    @Override
    public UObject getObject() {
        return object;
    }

    @Override
    public Queue<Command> getCommandQueue() {
        return commandQueue;
    }
}