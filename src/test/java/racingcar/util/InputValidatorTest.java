package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1a", "!", "", "\n"})
    void 시도_횟수가_숫자가_아니면_예외를_던진다(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryCount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "9999999999", "999999999999999999999"})
    void 시도_횟수가_int_범위를_벗어나면_예외를_던진다(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryCount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"이름!,", "!!@@이름", "이름~~?", "", ";;", "\n"})
    void 자동차_이름_형식이_틀리면_예외를_던진다(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateDelimiter(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"공 백", " 공백 "})
    void 자동차_이름에_공백이_있어도_예외를_던지지_않는다(String input) {
        assertDoesNotThrow(() -> InputValidator.validateDelimiter(input));
    }
}
