package ru.alexnsk.starwars.adapter;

import org.junit.jupiter.api.Test;
import ru.alexnsk.starwars.model.Spaceship;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static ru.alexnsk.starwars.enums.UObjectFieldName.ANGULAR_VELOCITY;
import static ru.alexnsk.starwars.enums.UObjectFieldName.DIRECTION;

class RotatableAdapterTest {

    @Test
    public void getDirection_WhenDirectionIsSet_ReturnDirectionValue() {
        var spaceship = new Spaceship();
        spaceship.setObject(DIRECTION.getName(), 3);
        var rotableAdapter = new RotatableAdapter(spaceship);
        assertThat(rotableAdapter.getDirection())
                .isEqualTo(3);
    }

    @Test
    public void setDirection_WhenDirectionProvided_SetDirection() {
        var rotableAdapter = new RotatableAdapter(new Spaceship());

        assumeThat(rotableAdapter.getDirection()).isNull();

        rotableAdapter.setDirection(5);
        assertThat(rotableAdapter.getDirection())
                .isEqualTo(5);
    }

    @Test
    public void getAngularVelocity_WhenAngularVelocityIsSet_ReturnAngularVelocityValue() {
        var spaceship = new Spaceship();
        spaceship.setObject(ANGULAR_VELOCITY.getName(), 5);
        var rotableAdapter = new RotatableAdapter(spaceship);
        assertThat(rotableAdapter.getAngularVelocity())
                .isEqualTo(5);
    }
}