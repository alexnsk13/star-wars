package ru.alexnsk.starwars.movement;

import org.junit.jupiter.api.Test;
import ru.alexnsk.starwars.model.MovableObject;
import ru.alexnsk.starwars.model.Vector;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MovementExecutorTest {

    @Test
    public void execute_WhenCorrectMovableData_ChangePosition() {
        var position = new Vector(12, 5);
        var velocity = new Vector(-7, 3);
        var movableObject = new MovableObject(position, velocity);
        var executor = new MovementExecutor(movableObject);

        executor.execute();

        assertThat(movableObject.getPosition())
                .extracting(Vector::getX, Vector::getY)
                .containsExactly(5, 8);
    }

    @Test
    public void execute_WhenPositionIsNotSet_ThrowException() {
        var velocity = new Vector(-7, 3);
        var executor = new MovementExecutor(new MovableObject(null, velocity));

        assertThatThrownBy(executor::execute)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Current position is not set, cannot move.");
    }

    @Test
    public void execute_WhenVelocityIsNotSet_ThrowException() {
        var position = new Vector(12, 5);
        var executor = new MovementExecutor(new MovableObject(position, null));

        assertThatThrownBy(executor::execute)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Velocity is not set, cannot move.");
    }

    @Test
    public void execute_WhenZeroVelocity_ThrowException() {
        var position = new Vector(12, 5);
        var velocity = new Vector(0, 0);
        var executor = new MovementExecutor(new MovableObject(position, velocity));

        assertThatThrownBy(executor::execute)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Zero velocity, cannot move.");
    }
}