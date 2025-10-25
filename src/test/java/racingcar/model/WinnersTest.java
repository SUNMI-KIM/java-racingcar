package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Winners;

public class WinnersTest {

    @Test
    void Winners_toString_호출시_이름이_쉼표로_구분되어_반환된다() {

        // given
        List<String> winnersNames = List.of("wooteco", "woo", "te", "co");
        Winners winners = new Winners(winnersNames);

        // when
        String result = winners.toString();

        // then
        assertThat(result).isEqualTo("wooteco, woo, te, co");
    }
}
