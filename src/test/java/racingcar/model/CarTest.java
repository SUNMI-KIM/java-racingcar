package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;

public class CarTest {

    @Test
    void 자동차가_이동하면_이동거리가_1_증가한다() {

        // given
        Car car = new Car("wooteco");

        // when
        car.move();

        // then
        assertEquals(car.toString(), "wooteco : -");
    }

    @Test
    void 자동차를_생성하면_이동거리를_0으로_초기화된다() {

        // given
        Car car = new Car("wooteco");

        // when, then
        assertEquals(car.toString(), "wooteco : ");
    }
}
