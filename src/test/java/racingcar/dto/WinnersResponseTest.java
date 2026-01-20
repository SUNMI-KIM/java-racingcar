package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.WinnersResponse;

public class WinnersResponseTest {

    @Test
    void Winners_toString_호출시_이름이_쉼표로_구분되어_반환된다() {

        // given
        List<String> winnersNames = List.of("wooteco", "woo", "te", "co");
        WinnersResponse winnersResponse = new WinnersResponse(winnersNames);

        // when
        String result = winnersResponse.toString();

        // then
        assertThat(result).isEqualTo("최종 우승자 : wooteco, woo, te, co");
    }
}
