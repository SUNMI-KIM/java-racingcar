package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameRoundResponse {
    private List<List<String>> gameRounds;

    public GameRoundResponse() {
        gameRounds = new ArrayList<>();
    }

    public void add(List<String> gameRound) {
        gameRounds.add(gameRound);
    }

    @Override
    public String toString() {
        return gameRounds.stream()
                .map(round -> String.join("\n", round))
                .collect(Collectors.joining("\n\n", "", "\n"));
    }
}
