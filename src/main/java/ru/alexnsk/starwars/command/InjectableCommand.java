package ru.alexnsk.starwars.command;

public interface InjectableCommand {

    void inject(Command command);
}