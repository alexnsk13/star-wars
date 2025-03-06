package ru.alexnsk.starwars.command.move;

import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.model.Vector;
import ru.alexnsk.starwars.model.Movable;

public class MoveCommand implements Command {

    private final Movable movable;

    public MoveCommand(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void execute() {
        var position = movable.getPosition();
        if (position == null) {
            throw new IllegalStateException("Current position is not set, cannot move.");
        }

        var velocity = movable.getVelocity();
        if (velocity == null) {
            throw new IllegalStateException("Velocity is not set, cannot move.");
        }

        if (velocity.getX() == 0 && velocity.getY() == 0) {
            throw new IllegalStateException("Zero velocity, cannot move.");
        }

        movable.setPosition(Vector.plus(position, velocity));
    }
}