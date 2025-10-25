package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class RacingGameControllerTest extends NsTest {

    @Test
    void 랜덤_포함_통합_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni,jun", "3");
            String output = output();

            assertThat(output)
                    .contains("실행 결과")
                    .contains("최종 우승자 : pobi, jun");
        }, 6, 2, 5, 1, 6, 4, 8, 3, 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a", "!", "", "\n", "2147483648", "9999999999", "999999999999999999999,"
            + " \"이름!,\", \"!!@@이름\", \"이름~~?\", \"\", \";;\", \" \", \"\\n\", \"한글 영어\", \"5글자이상글자\""})
    void 올바르지_않은_입력이_들어오면_예외를_반환한다(String input) {
        assertThrows(IllegalArgumentException.class, () -> run(input, "3"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
