package ru.alexnsk.starwars.command.impl;

import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.InjectableCommand;

public class BridgeCommand implements Command, InjectableCommand {

    private Command internalCommand;

    public BridgeCommand(Command internalCommand) {
        this.internalCommand = internalCommand;
    }

    @Override
    public void execute() {
        internalCommand.execute();
    }

    @Override
    public void inject(Command command) {
        internalCommand = command;
    }
}
