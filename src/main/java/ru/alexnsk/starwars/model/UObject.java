package ru.alexnsk.starwars.model;

import java.io.Serializable;

public interface UObject extends Serializable {

    Object getObject(String key);

    void setObject(String key, Object value);
}