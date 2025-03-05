package ru.alexnsk.starwars.command.impl;

import ru.alexnsk.starwars.adapter.MovableAdapter;
import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.MoveCommandStartable;
import ru.alexnsk.starwars.model.UObject;

import java.util.Queue;

public class StartMoveCommand implements MoveCommandStartable, Command {

    private UObject movingObject;
    private int velocity;
    private Queue<Command> commandQueue;

    public StartMoveCommand(UObject movingObject, int velocity, Queue<Command> commandQueue)
    {
        this.movingObject = movingObject;
        this.velocity = velocity;
        this.commandQueue = commandQueue;
    }

    @Override
    public void execute() {
        var changeVelocityCommand = new ChangeVelocityCommand(movingObject);
        changeVelocityCommand.setVelocity(velocity);

        var movable = new MovableAdapter(movingObject);
        commandQueue.add(new MoveCommand(movable));
    }

    @Override
    public UObject getObject() {
        return movingObject;
    }

    @Override
    public int getVelocity() {
        return velocity;
    }

    @Override
    public Queue<Command> getCommandsQueue() {
        return commandQueue;
    }
}