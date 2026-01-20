package racingcar.view;

import racingcar.dto.GameResponse;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.dto.WinnersResponse;

public class OutputView {

    private static final String GAME_START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printStartMessage() {
        System.out.println();
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGames(GameResponse gameResponse) {
        System.out.println(gameResponse);
    }
}
