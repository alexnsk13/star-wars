package ru.alexnsk.starwars.command.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.alexnsk.starwars.command.move.MoveCommand;

import static org.mockito.Mockito.*;

class BridgeCommandTest {

    private MoveCommand moveCommandMock;
    private BridgeCommand bridgeCommand;

    @BeforeEach
    public void setUp() {
        moveCommandMock = mock(MoveCommand.class);
        bridgeCommand = new BridgeCommand(moveCommandMock);
    }

    @Test
    public void execute_ShouldCallInternalCommandExecuteMethod() {
        bridgeCommand.execute();
        verify(moveCommandMock).execute();
    }

    @Test
    public void inject_WhenNewCommandInjected_UseNewCommandWhenExecuteMethodCalled() {
        var noOpCommandMock = mock(NoOpCommand.class);
        bridgeCommand.inject(noOpCommandMock);

        bridgeCommand.execute();

        verify(noOpCommandMock).execute();
        verify(moveCommandMock, never()).execute();
    }
}