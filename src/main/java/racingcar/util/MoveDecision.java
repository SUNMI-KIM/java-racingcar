package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveDecision {

    private static final int MOVE_CONDITION = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public static boolean canMove() {
        return generateRandomNumber() >= MOVE_CONDITION;
    }
}
