package ru.alexnsk.starwars.command.impl;

import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.model.Rotatable;

public class RotateCommand implements Command {

    public static final int FULL_CIRCLE = 360;

    private final Rotatable rotatable;

    public RotateCommand(Rotatable rotatable) {
        this.rotatable = rotatable;
    }

    @Override
    public void execute() {
        int newAngle = (rotatable.getDirection() + rotatable.getAngularVelocity()) % FULL_CIRCLE;
        if (newAngle < 0) {
            newAngle += FULL_CIRCLE;
        }
        rotatable.setDirection(newAngle);
    }
}
