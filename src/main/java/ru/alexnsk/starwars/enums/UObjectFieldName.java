package ru.alexnsk.starwars.enums;

public enum UObjectFieldName {
    VELOCITY("velocity"),
    POSITION("position");

    private final String name;

    UObjectFieldName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}