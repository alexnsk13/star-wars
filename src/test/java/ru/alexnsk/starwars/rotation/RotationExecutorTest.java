package ru.alexnsk.starwars.rotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.alexnsk.starwars.model.RotatableObject;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static ru.alexnsk.starwars.rotation.RotationExecutor.FULL_CIRCLE;

public class RotationExecutorTest {

    private static final int TEST_INITIAL_ANGLE = 33;

    @ParameterizedTest
    @MethodSource("provideAnglesForExecute")
    public void execute_WhenGivenAngle_ShouldRotateCorrectly(int angle, int expectedResult) {
        var rotatableObject = new RotatableObject(TEST_INITIAL_ANGLE);
        var executor = new RotationExecutor(rotatableObject);

        executor.execute(angle);
        assertThat(rotatableObject.getAngle()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideAnglesForExecute() {
        return Stream.of(
                Arguments.of(0, TEST_INITIAL_ANGLE),
                Arguments.of(FULL_CIRCLE, TEST_INITIAL_ANGLE),
                Arguments.of(378, 51),
                Arguments.of(90, 123),
                Arguments.of(-90, 303)
        );
    }
}