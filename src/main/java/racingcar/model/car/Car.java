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

    int getDistance() {
        return distance;
    }

    boolean isWinner(int maxDistance) {
        return distance == maxDistance;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
