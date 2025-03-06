package ru.alexnsk.starwars.model;

import java.util.HashMap;
import java.util.Map;

public class Spaceship implements UObject {

    private final Map<String, Object> data = new HashMap<>();

    @Override
    public Object getObject(String key) {
        return data.get(key);
    }

    @Override
    public void setObject(String key, Object value) {
        data.put(key, value);
    }
}