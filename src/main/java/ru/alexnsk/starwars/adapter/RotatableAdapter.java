package ru.alexnsk.starwars.adapter;

import ru.alexnsk.starwars.model.Rotatable;
import ru.alexnsk.starwars.model.UObject;

import static ru.alexnsk.starwars.enums.UObjectFieldName.ANGULAR_VELOCITY;
import static ru.alexnsk.starwars.enums.UObjectFieldName.DIRECTION;

public class RotatableAdapter implements Rotatable {

    private final UObject uObject;

    public RotatableAdapter(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public int getDirection() {
        return (Integer) uObject.getObject(DIRECTION.getName());
    }

    @Override
    public int getAngularVelocity() {
        return (Integer) uObject.getObject(ANGULAR_VELOCITY.getName());
    }

    @Override
    public void setDirection(int direction) {
        uObject.setObject(DIRECTION.getName(), direction);
    }
}
