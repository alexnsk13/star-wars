package ru.alexnsk.starwars.model;

import ru.alexnsk.starwars.rotation.Rotatable;

public class RotatableObject implements Rotatable {

    private int angle;

    public RotatableObject(int angle) {
        this.angle = angle;
    }

    @Override
    public int getAngle() {
        return angle;
    }

    @Override
    public void setAngle(int angle) {
        this.angle = angle;
    }
}