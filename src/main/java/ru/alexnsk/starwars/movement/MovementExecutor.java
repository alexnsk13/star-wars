package ru.alexnsk.starwars.movement;

import ru.alexnsk.starwars.model.Vector;

public class MovementExecutor {

    private final Movable movable;

    public MovementExecutor(Movable movable) {
        this.movable = movable;
    }

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