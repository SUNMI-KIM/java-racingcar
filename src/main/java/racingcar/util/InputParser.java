package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static List<String> parseInput(String input) {

        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static int parseTryCount(String tryCount) {

        return Integer.parseInt(tryCount);
    }
}
