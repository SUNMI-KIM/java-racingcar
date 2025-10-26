package racingcar.model.car;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.WinnersResponse;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }

    public List<String> findWinners() {
        int maxDistance = findMaxDistance();

        return cars.stream()
                .filter(car -> car.isWinner(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
