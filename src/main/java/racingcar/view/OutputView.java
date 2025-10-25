package racingcar.view;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.Winners;

public class OutputView {

    public static void printRoundResult(Cars cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinners(Winners winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
