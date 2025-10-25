package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.car.Winners;
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
        InputValidator.validateCarName(carNames);

        String tryCount = InputView.inputTryCount();
        InputValidator.validateTryCount(tryCount);

        Cars cars = new Cars(InputParser.parseInput(carNames));
        int tryCountValue = InputParser.parseTryCount(tryCount);

        OutputView.printStartMessage();
        for (int i = 0; i < tryCountValue; i++) {
            racingGameService.playRound(cars);
            OutputView.printRoundResult(cars);
        }

        Winners winners = cars.findWinners();
        OutputView.printWinners(winners);
    }

}
