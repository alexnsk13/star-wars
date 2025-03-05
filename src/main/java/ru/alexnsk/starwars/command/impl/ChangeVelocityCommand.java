package ru.alexnsk.starwars.command.impl;

import ru.alexnsk.starwars.command.VelocityCommandChangeable;
import ru.alexnsk.starwars.model.UObject;

public class ChangeVelocityCommand implements VelocityCommandChangeable {

    private final UObject uObject;

    public ChangeVelocityCommand(UObject uObject) {
        this.uObject = uObject;
    }

    @Override
    public void setVelocity(int velocity) {
        uObject.setObject("velocity", velocity);
    }
}