package racingcar.util;

public class InputValidator {

    private static final String INVALID_TRY_COUNT_MESSAGE = "시도 횟수 입력이 형식에 맞지 않습니다.";
    private static final String TRY_COUNT_REGEX = "[1-9][0-9]*";

    private static final String INVALID_CAR_NAME_MESSAGE = "차 이름은 1~5자의 한글 또는 영어로만 입력해야 합니다.";
    private static final String CAR_NAME_REGEX = "^([가-힣a-zA-Z]{1,5})(,([가-힣a-zA-Z]{1,5}))*";

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

    public static void validateCarName(String input) {
        if (!input.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }
}
