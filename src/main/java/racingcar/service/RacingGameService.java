package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.GameResponse;
import racingcar.dto.GameRoundResponse;
import racingcar.dto.WinnersResponse;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.util.MoveDecision;
import racingcar.view.OutputView;

public class RacingGameService {

    public List<String> playRound(Cars cars) {
        List<String> gameRound = new ArrayList<>();
        for (Car car : cars) {
            if (MoveDecision.canMove()) {
                car.move();
            }
            gameRound.add(car.toString());
        }
        return gameRound;
    }

    public GameResponse playGames(Cars cars, int tryCount) {
        GameRoundResponse gameRoundResponse = new GameRoundResponse();

        for (int i = 0; i < tryCount; i++) {
            gameRoundResponse.add(playRound(cars));
        }

        WinnersResponse winnersResponse = new WinnersResponse(cars.findWinners());
        return new GameResponse(gameRoundResponse, winnersResponse);
    }
}
