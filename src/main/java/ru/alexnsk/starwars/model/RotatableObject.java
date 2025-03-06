package ru.alexnsk.starwars.model;

public class RotatableObject implements Rotatable {

    private int direction;
    private int angularVelocity;

    public RotatableObject(int direction, int angularVelocity) {
        this.direction = direction;
        this.angularVelocity = angularVelocity;
    }

    @Override
    public Integer getDirection() {
        return direction;
    }

    @Override
    public Integer getAngularVelocity() {
        return angularVelocity;
    }

    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }
}