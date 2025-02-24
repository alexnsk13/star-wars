package ru.alexnsk.starwars.movement;

import ru.alexnsk.starwars.model.Vector;

public interface Movable {

    Vector getPosition();
    Vector getVelocity();
    void setPosition(Vector vector);
}