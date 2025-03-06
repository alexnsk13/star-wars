package ru.alexnsk.starwars.adapter;

import org.junit.jupiter.api.Test;
import ru.alexnsk.starwars.model.Spaceship;
import ru.alexnsk.starwars.model.Vector;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static ru.alexnsk.starwars.enums.UObjectFieldName.POSITION;
import static ru.alexnsk.starwars.enums.UObjectFieldName.VELOCITY;

class MovableAdapterTest {

    @Test
    public void getPosition_WhenPositionIsSet_ReturnPositionValue() {
        var spaceship = new Spaceship();
        spaceship.setObject(POSITION.getName(), new Vector(2, 3));
        var movableAdapter = new MovableAdapter(spaceship);
        assertThat(movableAdapter.getPosition())
                .extracting(Vector::getX, Vector::getY)
                .containsExactly(2, 3);
    }

    @Test
    public void setPosition_WhenPositionVectorProvided_SetPosition() {
        var movableAdapter = new MovableAdapter(new Spaceship());

        assumeThat(movableAdapter.getPosition()).isNull();

        movableAdapter.setPosition(new Vector(3, 4));
        assertThat(movableAdapter.getPosition())
                .extracting(Vector::getX, Vector::getY)
                .containsExactly(3, 4);
    }

    @Test
    public void getVelocity_WhenVelocityIsSet_ReturnVelocityValue() {
        var spaceship = new Spaceship();
        spaceship.setObject(VELOCITY.getName(), new Vector(2, 3));
        var movableAdapter = new MovableAdapter(spaceship);
        assertThat(movableAdapter.getVelocity())
                .extracting(Vector::getX, Vector::getY)
                .containsExactly(2, 3);
    }
}