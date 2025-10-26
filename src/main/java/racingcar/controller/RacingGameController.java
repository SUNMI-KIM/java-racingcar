package racingcar.controller;

import java.util.List;
import racingcar.dto.GameResponse;
import racingcar.model.car.Cars;
import racingcar.dto.WinnersResponse;
import racingcar.service.RacingGameService;
import racingcar.util.InputParser;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        String carNames = InputView.inputCarNames();
        InputValidator.validateDelimiter(carNames);

        String tryCount = InputView.inputTryCount();
        InputValidator.validateTryCount(tryCount);

        List<String> carNamesValue = InputParser.parseInput(carNames);
        InputValidator.validateCarNames(carNamesValue);

        Cars cars = new Cars(carNamesValue);
        int tryCountValue = InputParser.parseTryCount(tryCount);

        OutputView.printStartMessage();
        GameResponse gameResponse = racingGameService.playGames(cars, tryCountValue);
        OutputView.printGames(gameResponse);
    }

}
