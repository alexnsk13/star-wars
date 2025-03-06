package ru.alexnsk.starwars.command.impl;

import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.MoveCommandEndable;
import ru.alexnsk.starwars.model.UObject;

import java.util.Queue;

import static ru.alexnsk.starwars.enums.UObjectFieldName.VELOCITY;

public class EndMoveCommand implements MoveCommandEndable, Command {

    private UObject movingObject;
    private Command endableCommand;
    private Queue<Command> commandQueue;

    public EndMoveCommand(UObject movingObject, Command endableCommand, Queue<Command> commandQueue)
    {
        this.movingObject = movingObject;
        this.endableCommand = endableCommand;
        this.commandQueue = commandQueue;
    }

    @Override
    public void execute() {
        movingObject.removeObject(VELOCITY.getName());
        commandQueue.remove(endableCommand);
    }

    @Override
    public Command getMoveCommand() {
        return endableCommand;
    }

    @Override
    public UObject getObject() {
        return movingObject;
    }

    @Override
    public Queue<Command> getCommandsQueue() {
        return commandQueue;
    }
}
