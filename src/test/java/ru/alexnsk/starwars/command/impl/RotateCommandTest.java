package ru.alexnsk.starwars.command.impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.alexnsk.starwars.command.rotate.RotateCommand;
import ru.alexnsk.starwars.model.RotatableObject;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.alexnsk.starwars.command.rotate.RotateCommand.FULL_CIRCLE;

public class RotateCommandTest {

    private static final int TEST_INITIAL_DIRECTION = 33;

    @ParameterizedTest
    @MethodSource("provideAnglesForExecute")
    public void execute_WhenGivenAngle_ShouldRotateCorrectly(int angle, int expectedResult) {
        var rotatableObject = new RotatableObject(TEST_INITIAL_DIRECTION, angle);
        var executor = new RotateCommand(rotatableObject);

        executor.execute();
        assertThat(rotatableObject.getDirection()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideAnglesForExecute() {
        return Stream.of(
                Arguments.of(0, TEST_INITIAL_DIRECTION),
                Arguments.of(FULL_CIRCLE, TEST_INITIAL_DIRECTION),
                Arguments.of(378, 51),
                Arguments.of(90, 123),
                Arguments.of(-90, 303)
        );
    }
}