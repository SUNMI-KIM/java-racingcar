package racingcar.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Winners;

public class WinnersTest {

    @Test
    void Cars를_iterator로_순회하면_모든_Car가_출력된다() {

        //given
        List<String> winnersNames = List.of("wooteco", "woo", "te", "co");
        Winners winners = new Winners(winnersNames);

        //when, then
        System.out.println(winners.toString());
    }
}
