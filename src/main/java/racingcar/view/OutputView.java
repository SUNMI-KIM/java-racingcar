package racingcar.view;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class OutputView {

    public static void printRoundResult(Cars cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
