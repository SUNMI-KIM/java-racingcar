package racingcar.model.car;

public class Car {

    private int distance = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        distance++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
