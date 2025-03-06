package ru.alexnsk.starwars.model;

public interface Rotatable {

    Integer getDirection();
    Integer getAngularVelocity();
    void setDirection(int direction);
}