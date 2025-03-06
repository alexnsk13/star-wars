package ru.alexnsk.starwars.command.impl;

import org.junit.jupiter.api.Test;
import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.model.Spaceship;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static ru.alexnsk.starwars.enums.UObjectFieldName.VELOCITY;

class StartMoveCommandTest {

    @Test
    public void execute_WhenMovingObjectAndVelocityProvided_SetVelocityAndAddCommandToQueue() {
        var spaceShip = new Spaceship();
        var velocity = 5;
        var queue = new ArrayDeque<Command>();
        var command = new StartMoveCommand(spaceShip, velocity, queue);

        assumeThat(command.getObject().getObject(VELOCITY.getName())).isNull();
        assumeThat(command.getVelocity()).isEqualTo(velocity);

        command.execute();

        assertThat(spaceShip.getObject(VELOCITY.getName())).isEqualTo(velocity);
        assertThat(command.getCommandsQueue()).hasSize(1);
    }
}