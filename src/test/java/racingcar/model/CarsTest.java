package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.Winners;
import racingcar.service.RacingGameService;

public class CarsTest {

    @Test
    void Cars를_iterator로_순회하면_모든_Car가_출력된다() {

        //given
        List<String> carsNames = List.of("wooteco", "woo", "te", "co");
        Cars cars = new Cars(carsNames);

        //when, then
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    void 가장_멀리_이동한_자동차가_우승자로_선정된다() {

        assertRandomNumberInRangeTest(() -> {
            // given
            RacingGameService racingGameService = new RacingGameService();
            List<String> carNames = List.of("pobi", "woni", "jun");
            Cars cars = new Cars(carNames);

            // when
            racingGameService.playRound(cars);
            Winners winners = cars.findWinners();

            // then
            assertThat(winners.toString()).isEqualTo("pobi");
        }, 6, 1, 2);
    }
}
