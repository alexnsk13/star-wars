package ru.alexnsk.starwars.rotation;

public class RotationExecutor {

    public static final int FULL_CIRCLE = 360;

    private final Rotatable rotatable;

    public RotationExecutor(Rotatable rotatable) {
        this.rotatable = rotatable;
    }

    public void execute(int angle) {
        int newAngle = (rotatable.getAngle() + angle) % FULL_CIRCLE;
        if (newAngle < 0) {
            newAngle += FULL_CIRCLE;
        }
        rotatable.setAngle(newAngle);
    }
}