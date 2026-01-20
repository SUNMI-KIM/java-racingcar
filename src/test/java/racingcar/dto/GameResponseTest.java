package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameResponseTest {

    @Test
    void 게임_라운드_결과와_우승자_출력이_순서대로_포함된다() {
        // given
        GameRoundResponse gameRoundResponse = new GameRoundResponse();
        gameRoundResponse.add(List.of("pobi : -", "woni : "));
        gameRoundResponse.add(List.of("pobi : --", "woni : -"));

        WinnersResponse winnersResponse = new WinnersResponse(List.of("pobi", "jun"));

        GameResponse gameResponse = new GameResponse(gameRoundResponse, winnersResponse);

        // when
        String result = gameResponse.toString();

        // then
        String expected =
                "pobi : -\n" +
                        "woni : \n\n" +
                        "pobi : --\n" +
                        "woni : -\n\n" +
                        "최종 우승자 : pobi, jun";

        assertThat(result).isEqualTo(expected);
    }
}
