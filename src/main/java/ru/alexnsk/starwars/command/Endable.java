package ru.alexnsk.starwars.command;

import ru.alexnsk.starwars.model.UObject;

public interface Endable {

    Command getCommand();
    UObject getObject();
}