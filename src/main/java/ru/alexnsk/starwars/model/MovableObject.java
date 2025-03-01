package ru.alexnsk.starwars.model;

import ru.alexnsk.starwars.movement.Movable;

public class MovableObject implements Movable {

    private Vector position;
    private Vector velocity;

    public MovableObject(Vector position, Vector velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public Vector getPosition() {
        return position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }
}
