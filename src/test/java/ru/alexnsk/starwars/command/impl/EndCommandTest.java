package ru.alexnsk.starwars.command.impl;

import org.junit.jupiter.api.Test;
import ru.alexnsk.starwars.command.move.MoveEndable;
import ru.alexnsk.starwars.model.Spaceship;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EndCommandTest {

    @Test
    void execute_EndableWithBridgeCommandProvided_InjectNoOpCommandToBridgeCommand() {
        var bridgeCommand = mock(BridgeCommand.class);
        var moveEndable = new MoveEndable(new Spaceship(), bridgeCommand);
        var endCommand = new EndCommand(moveEndable);

        endCommand.execute();

        verify(bridgeCommand).inject(any(NoOpCommand.class));
    }
}