package ru.alexnsk.starwars.model;

public interface Movable {

    Vector getPosition();
    Vector getVelocity();
    void setPosition(Vector vector);
}