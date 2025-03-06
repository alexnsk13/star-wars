package ru.alexnsk.starwars.command.impl;

import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.Startable;

public class StartCommand implements Command {

    private final Startable startable;

    public StartCommand(Startable startable) {
        this.startable = startable;
    }

    @Override
    public void execute() {
        var command = startable.createCommand();
        startable.getCommandQueue().add(command);
    }
}