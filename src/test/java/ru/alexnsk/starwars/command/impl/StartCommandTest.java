package ru.alexnsk.starwars.command.impl;

import org.junit.jupiter.api.Test;
import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.command.Startable;
import ru.alexnsk.starwars.command.move.MoveStartable;
import ru.alexnsk.starwars.command.rotate.RotateStartable;
import ru.alexnsk.starwars.enums.UObjectFieldName;
import ru.alexnsk.starwars.model.Spaceship;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.alexnsk.starwars.enums.UObjectFieldName.ANGULAR_VELOCITY;
import static ru.alexnsk.starwars.enums.UObjectFieldName.VELOCITY;

class StartCommandTest {

    @Test
    public void execute_WhenMoveStartableProvided_SetVelocityAndAddToCommandQueue() {
        var velocity = 5;
        var uObject = new Spaceship();
        var startable = new MoveStartable(uObject, velocity, new ArrayDeque<>());
        verifySetVelocityAndCommandAddedToQueue(startable, VELOCITY);
    }

    @Test
    public void execute_WhenRotateStartableProvided_SetAngularVelocityAndAddCommandToQueue() {
        var velocity = 5;
        var uObject = new Spaceship();
        var startable = new RotateStartable(uObject, velocity, new ArrayDeque<>());
        verifySetVelocityAndCommandAddedToQueue(startable, ANGULAR_VELOCITY);
    }

    private void verifySetVelocityAndCommandAddedToQueue(Startable startable, UObjectFieldName name) {
        var startCommand = new StartCommand(startable);

        startCommand.execute();

        assertThat(startable.getCommandQueue()).hasSize(1);
        assertThat(startable.getCommandQueue().poll()).isInstanceOf(BridgeCommand.class);
        assertThat(startable.getObject().getObject(name.getName())).isEqualTo(startable.getVelocity());
    }
}