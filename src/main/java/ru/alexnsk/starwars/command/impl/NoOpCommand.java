package ru.alexnsk.starwars.command.impl;

import ru.alexnsk.starwars.command.Command;

public class NoOpCommand implements Command {

    @Override
    public void execute() {

    }
}
