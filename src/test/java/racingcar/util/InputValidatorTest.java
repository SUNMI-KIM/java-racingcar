package racingcar.util;

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
    @ValueSource(strings = {"이름!,", "!!@@이름", "이름~~?", "", ";;", " ", "\n", "한글 영어", "5글자이상글자"})
    void 자동차_이름_형식이_틀리면_예외를_던진다(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(input));
    }
}
