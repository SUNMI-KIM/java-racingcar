package racingcar.Service;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.util.MoveDecision;

public class RacingGameService {

    public void playRound(Cars cars) {
        for (Car car : cars) {
            if (MoveDecision.canMove()) {
                car.move();
            }
        }
    }
}
