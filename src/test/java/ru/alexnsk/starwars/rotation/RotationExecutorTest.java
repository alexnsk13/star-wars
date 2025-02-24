package ru.alexnsk.starwars.rotation;

import org.junit.jupiter.api.Test;
import ru.alexnsk.starwars.model.RotatableObject;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RotationExecutorTest {

    @Test
    public void execute_WhenRotationAngleIsZero_DoNotChangeObjectAngle() {
        var currentAngle = 24;
        testExecute(currentAngle, 0, currentAngle);
    }

    @Test
    public void execute_WhenRotationAngleIsMultiple360_DoNotChangeObjectAngle() {
        var currentAngle = 33;
        testExecute(currentAngle, 360, currentAngle);
        testExecute(currentAngle, 360, currentAngle);
    }

    @Test
    public void execute_WhenRotationAngleMoreThan360_Rotate() {
        testExecute(43, 378, 61);
    }

    @Test
    public void execute_WhenRotationAngleIsPositive_Rotate() {
        testExecute(43, 90, 133);
    }

    @Test
    public void execute_WhenRotatingAngleIsNegative_Rotate() {
        testExecute(30, -90, 300);
    }

    private void testExecute(int currentAngle, int rotatedAngle, int expected) {
        var rotatableObject = new RotatableObject(currentAngle);
        var executor = new RotationExecutor(rotatableObject);

        executor.execute(rotatedAngle);
        assertThat(rotatableObject.getAngle()).isEqualTo(expected);
    }
}