package ru.alexnsk.starwars.adapter;

import ru.alexnsk.starwars.model.UObject;
import ru.alexnsk.starwars.model.Vector;
import ru.alexnsk.starwars.model.Movable;

public class MovableAdapter implements Movable {

    private final UObject uObject;

    public MovableAdapter(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public Vector getPosition() {
        return (Vector) uObject.getObject("position");
    }

    @Override
    public Vector getVelocity() {
        return (Vector) uObject.getObject("velocity");
    }

    @Override
    public void setPosition(Vector vector) {
        uObject.setObject("position", vector);
    }
}