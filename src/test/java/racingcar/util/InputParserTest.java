package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputParserTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void 입력값을_쉼표로_분리하면_리스트로_반환된다(String input, List<String> expected) {
        // when
        List<String> result = InputParser.parseInput(input);

        // then
        assertThat(result).containsExactlyElementsOf(expected);
    }

    private static Stream<org.junit.jupiter.params.provider.Arguments> inputProvider() {
        return Stream.of(
                Arguments.of("pobi,crong,honux", List.of("pobi", "crong", "honux")),
                Arguments.of("a,b,c", List.of("a", "b", "c")),
                Arguments.of("one,two", List.of("one", "two")),
                Arguments.of("single", List.of("single"))
        );
    }
}
