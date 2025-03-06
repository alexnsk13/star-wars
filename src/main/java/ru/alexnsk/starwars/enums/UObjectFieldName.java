package ru.alexnsk.starwars.enums;

public enum UObjectFieldName {
    VELOCITY("velocity"),
    POSITION("position"),
    DIRECTION("direction"),
    ANGULAR_VELOCITY("angularVelocity");

    private final String name;

    UObjectFieldName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}