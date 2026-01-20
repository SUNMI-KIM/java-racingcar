package racingcar.exception;

public enum ErrorMessage {
    INVALID_TRY_COUNT_MESSAGE("시도 횟수 입력이 형식에 맞지 않습니다."),

    INVALID_INPUT_FORMAT_MESSAGE("자동차 이름은 쉼표(,)로 구분해야 하며, 한글, 영어, 숫자, 공백만 사용할 수 있습니다."),
    EMPTY_CAR_NAME_MESSAGE("자동차 이름은 비어 있을 수 없습니다."),
    DUPLICATE_CAR_NAME_MESSAGE("자동차 이름은 중복될 수 없습니다."),
    INVALID_CAR_NAME_LENGTH_MESSAGE("자동차 이름은 1자 이상, 5자 이하이어야 합니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
