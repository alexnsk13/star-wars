package ru.alexnsk.starwars.command;

import ru.alexnsk.starwars.model.UObject;

import java.util.Queue;

public interface Endable {

    Command getCommand();
    UObject getObject();
    Queue<Command> getCommandQueue();
}