package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final String INVALID_TRY_COUNT_MESSAGE = "시도 횟수 입력이 형식에 맞지 않습니다.";
    private static final String TRY_COUNT_REGEX = "[1-9][0-9]*";

    private static final String INVALID_CAR_NAME_MESSAGE = "차 이름은 1~5자의 한글 또는 영어로만 입력해야 합니다.";
    private static final String DELIMITER_REGEX = "([a-zA-Z가-힣0-9 ]+,)*[a-zA-Z가-힣0-9 ]+";

    public static void validateTryCount(String input) {
        if (!input.matches(TRY_COUNT_REGEX)) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    public static void validateDelimiter(String input) {
        if (!input.matches(DELIMITER_REGEX)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    public static void validateCarNames(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }

        Set<String> uniqueNames = new HashSet<>(cars);
        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }

        if (cars.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }
}
