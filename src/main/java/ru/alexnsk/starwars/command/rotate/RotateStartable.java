package ru.alexnsk.starwars.command.rotate;

import ru.alexnsk.starwars.adapter.RotatableAdapter;
import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.Startable;
import ru.alexnsk.starwars.command.impl.ChangeAngularVelocityCommand;
import ru.alexnsk.starwars.model.UObject;

import java.util.Queue;

public class RotateStartable implements Startable {

    private final UObject object;
    private final int velocity;
    private final Queue<Command> commandQueue;

    public RotateStartable(UObject object, int velocity, Queue<Command> commandQueue) {
        this.object = object;
        this.velocity = velocity;
        this.commandQueue = commandQueue;
    }

    @Override
    public UObject getObject() {
        return object;
    }

    @Override
    public int getVelocity() {
        return velocity;
    }

    @Override
    public Queue<Command> getCommandQueue() {
        return commandQueue;
    }

    @Override
    public Command createCommand() {
        var changeVelocityCommand = new ChangeAngularVelocityCommand(object);
        changeVelocityCommand.setVelocity(velocity);

        var movable = new RotatableAdapter(object);
        return new RotateCommand(movable);
    }
}
