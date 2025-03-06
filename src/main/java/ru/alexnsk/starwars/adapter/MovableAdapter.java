package ru.alexnsk.starwars.adapter;

import ru.alexnsk.starwars.model.UObject;
import ru.alexnsk.starwars.model.Vector;
import ru.alexnsk.starwars.model.Movable;

import static ru.alexnsk.starwars.enums.UObjectFieldName.POSITION;
import static ru.alexnsk.starwars.enums.UObjectFieldName.VELOCITY;

public class MovableAdapter implements Movable {

    private final UObject uObject;

    public MovableAdapter(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public Vector getPosition() {
        return (Vector) uObject.getObject(POSITION.getName());
    }

    @Override
    public Vector getVelocity() {
        return (Vector) uObject.getObject(VELOCITY.getName());
    }

    @Override
    public void setPosition(Vector vector) {
        uObject.setObject(POSITION.getName(), vector);
    }
}