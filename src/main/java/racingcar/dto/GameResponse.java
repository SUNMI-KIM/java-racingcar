package racingcar.dto;

public class GameResponse {

    private final GameRoundResponse gameRoundResponse;
    private final WinnersResponse winnersResponse;

    public GameResponse(GameRoundResponse gameRoundResponse, WinnersResponse winnersResponse) {
        this.gameRoundResponse = gameRoundResponse;
        this.winnersResponse = winnersResponse;
    }

    public String toString() {
        return gameRoundResponse.toString() + "\n" + winnersResponse.toString();
    }
}
