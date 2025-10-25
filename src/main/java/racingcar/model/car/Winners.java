package racingcar.model.car;

import java.util.List;

public class Winners {

    private final List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return String.join(", ", winners);
    }
}
