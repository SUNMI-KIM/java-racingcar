package racingcar.dto;

import java.util.List;

public class WinnersResponse {

    private final List<String> winners;

    public WinnersResponse(List<String> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return "최종 우승자 : " + String.join(", ", winners);
    }
}
