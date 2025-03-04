package ru.alexnsk.starwars.model;

public interface Rotatable {

    int getDirection();
    int getAngularVelocity();
    void setDirection(int direction);
}