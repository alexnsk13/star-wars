package ru.alexnsk.starwars.command.impl;

import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.Endable;

public class EndCommand implements Command {

    private final Endable endable;

    public EndCommand(Endable endable) {
        this.endable = endable;
    }

    @Override
    public void execute() {
        endable.getCommandQueue().remove(endable.getCommand());
    }
}
