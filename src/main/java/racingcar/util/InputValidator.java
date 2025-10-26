package racingcar.util;

import static racingcar.exception.ErrorMessage.DUPLICATE_CAR_NAME_MESSAGE;
import static racingcar.exception.ErrorMessage.EMPTY_CAR_NAME_MESSAGE;
import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME_LENGTH_MESSAGE;
import static racingcar.exception.ErrorMessage.INVALID_INPUT_FORMAT_MESSAGE;
import static racingcar.exception.ErrorMessage.INVALID_TRY_COUNT_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final String DELIMITER_REGEX = "([a-zA-Z가-힣0-9 ]+,)*[a-zA-Z가-힣0-9 ]+";
    private static final String TRY_COUNT_REGEX = "[1-9][0-9]*";

    public static void validateTryCount(String input) {
        if (!input.matches(TRY_COUNT_REGEX)) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE.getMessage());
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE.getMessage());
        }
    }

    public static void validateDelimiter(String input) {
        if (!input.matches(DELIMITER_REGEX)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_MESSAGE.getMessage());
        }
    }

    public static void validateCarNames(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_MESSAGE.getMessage());
        }

        Set<String> uniqueNames = new HashSet<>(cars);
        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE.getMessage());
        }

        if (cars.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE.getMessage());
        }
    }
}
