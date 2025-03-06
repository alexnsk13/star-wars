package ru.alexnsk.starwars.command.impl;

import ru.alexnsk.starwars.command.VelocityCommandChangeable;
import ru.alexnsk.starwars.model.UObject;

import static ru.alexnsk.starwars.enums.UObjectFieldName.ANGULAR_VELOCITY;

public class ChangeAngularVelocityCommand implements VelocityCommandChangeable {

    private final UObject uObject;

    public ChangeAngularVelocityCommand(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public void setVelocity(int velocity) {
        uObject.setObject(ANGULAR_VELOCITY.getName(), velocity);
    }
}