package racingcar.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

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
}
