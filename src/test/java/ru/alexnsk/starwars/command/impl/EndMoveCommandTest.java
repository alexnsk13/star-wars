package ru.alexnsk.starwars.command.impl;

import org.junit.jupiter.api.Test;
import ru.alexnsk.starwars.adapter.MovableAdapter;
import ru.alexnsk.starwars.command.Command;
import ru.alexnsk.starwars.model.Spaceship;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static ru.alexnsk.starwars.enums.UObjectFieldName.VELOCITY;

class EndMoveCommandTest {

    @Test
    public void execute_WhenMovingObjectAndEndableCommandProvided_RemoveCommandFromQueue() {
        var velocity = 5;
        var spaceShip = new Spaceship();
        spaceShip.setObject(VELOCITY.getName(), velocity);

        var moveCommand = new MoveCommand(new MovableAdapter(spaceShip));
        var queue = new ArrayDeque<Command>();
        queue.add(moveCommand);
        var command = new EndMoveCommand(spaceShip, moveCommand, queue);

        assumeThat(command.getCommandsQueue()).hasSize(1);
        assumeThat(command.getMoveCommand()).isEqualTo(moveCommand);
        assumeThat(command.getObject().getObject(VELOCITY.getName())).isEqualTo(velocity);

        command.execute();

        assertThat(command.getCommandsQueue()).isEmpty();
        assumeThat(command.getObject().getObject(VELOCITY.getName())).isNull();
    }

//    @Test
//    public void getObject() {
//        var spaceShip = new Spaceship();
//        var command = new EndMoveCommand(spaceShip, null, null);
//        assertThat(command.getObject()).isEqualTo(spaceShip);
//    }
//
//    @Test
//    public void getVelocity() {
//        var movable = new MovableAdapter(new Spaceship());
//        var command = new EndMoveCommand(new Spaceship(), new MoveCommand(movable), null);
//        assertThat(command.getMoveCommand()).isInstanceOf(MoveCommand.class);
//    }
//
//    @Test
//    public void getCommand() {
//        var command = new EndMoveCommand(new Spaceship(), null, new ArrayDeque<>());
//        assertThat(command.getCommandsQueue()).isInstanceOf(ArrayDeque.class);
//    }
}