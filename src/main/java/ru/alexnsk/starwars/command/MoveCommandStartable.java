package ru.alexnsk.starwars.command;

import ru.alexnsk.starwars.model.UObject;

import java.util.Map;
import java.util.Queue;

public interface MoveCommandStartable {

    UObject getObject();
    int getVelocity();
    Queue<Command> getCommandsQueue();
}