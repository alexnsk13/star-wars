package ru.alexnsk.starwars.model;

import ru.alexnsk.starwars.model.Vector;

public interface Movable {

    Vector getPosition();
    Vector getVelocity();
    void setPosition(Vector vector);
}