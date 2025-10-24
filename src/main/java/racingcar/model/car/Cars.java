package racingcar.model.car;

import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
