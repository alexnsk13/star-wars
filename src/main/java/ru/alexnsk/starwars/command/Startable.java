package ru.alexnsk.starwars.command;

import ru.alexnsk.starwars.model.UObject;

import java.util.Queue;

public interface Startable {

    UObject getObject();
    int getVelocity();
    Queue<Command> getCommandQueue();
    Command createCommand();
}