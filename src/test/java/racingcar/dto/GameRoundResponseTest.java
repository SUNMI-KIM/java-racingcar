package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameRoundResponseTest {

    @Test
    void 라운드별_자동차_결과가_줄바꿈과_공백으로_구분되어_출력된다() {
        // given
        GameRoundResponse response = new GameRoundResponse();
        response.add(List.of("pobi : -", "woni : "));
        response.add(List.of("pobi : --", "woni : -"));
        response.add(List.of("pobi : ---", "woni : --"));

        // when
        String result = response.toString();

        // then
        String expected =
                "pobi : -\n" +
                        "woni : \n\n" +
                        "pobi : --\n" +
                        "woni : -\n\n" +
                        "pobi : ---\n" +
                        "woni : --\n";

        assertThat(result).isEqualTo(expected);
    }
}
