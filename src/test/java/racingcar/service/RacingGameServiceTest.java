package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Cars;
import racingcar.dto.WinnersResponse;

public class RacingGameServiceTest {

    @Test
    void Random_값이_4_이상이면_차가_움직인다() {

        assertRandomNumberInRangeTest(() -> {
            // given
            RacingGameService racingGameService = new RacingGameService();
            List<String> carNames = List.of("pobi", "woni", "jun");
            Cars cars = new Cars(carNames);

            // when
            racingGameService.playRound(cars);
            WinnersResponse winnersResponse = cars.findWinners();

            // then
            assertThat(winnersResponse.toString()).isEqualTo("pobi, woni, jun");
        }, 6, 5, 4);
    }
}
