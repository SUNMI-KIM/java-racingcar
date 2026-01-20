# 자동차 경주


### 문제 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## 동작 시나리오


1. 자동차 이름 입력 및 검증
    - 사용자가 자동차 이름들을 입력한다. (예: `"pobi,woni,jun"`)
    - 입력 문자열을 검증한다. 아래의 경우 `IllegalArgumentException`를 발생시킨다.
        - 구분자가 쉼표가 아닐 때
        - 5글자 이상일 때
    - `split(”,”)`을 통해 나누어 자동차 이름 리스트를 만든다.
    - 나누어진 리스트를 통해 `Car` 객체를 생성한다.
    - 각각 만들어진 `Car` 객체를 `Cars`에 담는다.
2. 시도할 횟수 입력
    - 사용자가 자동차들이 몇 번 움직일지를 입력한다.
    - 입력값을 검증한다. 아래의 경우 `IllegalArgumentException`를 발생시킨다.
        - 입력값이 음수일때
        - 입력값이 숫자가 아닐때
3. 경주 진행
    - 지정된 횟수만큼 반복하면서 각 자동차를 `run()` 한다.
    - 각 자동차는 랜덤 값(0~9)을 기반으로 기준값 이상이면 전진(`move()`), 그 미만이면 이동하지 않는다.
    - 매 시도 후 자동차의 현재 위치(’-’)등 상태를 출력한다.
4. 우승자 결정 및 출력
    - 모든 횟수가 끝난 후, 가장 멀리 이동한 자동차들을 찾는다.

## 프로젝트 구조


![](https://velog.velcdn.com/images/hariaus/post/6ea4e73f-d0cc-4d48-b6e0-28101c61efcb/image.png)

```
├── main
│   └── java
│       └── racingcar
│           ├── Application.java
│           ├── controller
│           │   └── RacingGameController.java
│           ├── dto
│           │   ├── GameResponse.java
│           │   ├── GameRoundResponse.java
│           │   └── WinnersResponse.java
│           ├── exception
│           │   └── ErrorMessage.java
│           ├── model
│           │   └── car
│           │       ├── Car.java
│           │       └── Cars.java
│           ├── service
│           │   └── RacingGameService.java
│           ├── util
│           │   ├── InputParser.java
│           │   ├── InputValidator.java
│           │   └── MoveDecision.java
│           └── view
│               ├── InputView.java
│               └── OutputView.java
└── test
    └── java
        └── racingcar
            ├── ApplicationTest.java
            ├── controller
            │   └── RacingGameControllerTest.java
            ├── dto
            │   ├── GameResponseTest.java
            │   ├── GameRoundResponseTest.java
            │   └── WinnersResponseTest.java
            ├── model
            │   ├── CarTest.java
            │   └── CarsTest.java
            ├── service
            │   └── RacingGameServiceTest.java
            └── util
                ├── InputParserTest.java
                └── InputValidatorTest.java
```

## 기능 요구 사항


| **카테고리** | **기능** | **설명** |
| --- | --- | --- |
| **입력** | 자동차 이름 입력 | 사용자로부터 자동차 이름들을 입력받는다. |
| 입력  | 시도 횟수 입력 | 사용자로부터 반복 횟수를 입력 받는다. |
| **검증** | 자동차 이름 검증 | 이름이 1~5자 사이인지, 구분자가 쉼표(,)인지 검증한다. 조건에 맞지 않으면 예외를 발생시킨다. |
| **검증** | 시도 횟수 검증 | 입력된 시도 횟수가 숫자인지, 1 이상인지 검증한다. 조건에 맞지 않으면 예외를 발생시킨다. |
| 검증 | 동명이인 검증 | 입력된 자동차 이름 중 같은 이름이 있는지 확인한다. 조건에 맞지 않으면 예외를 발생시킨다.  |
| **파싱** | 자동차 이름 파싱 | 입력받은 문자열을 쉼표(,) 기준으로 분리하고, 공백 처리 후 자동차 이름 리스트로 변환한다. |
| **차 동작** | 이동 판단 | 랜덤 값을 생성하여 자동차가 전진할지 정지할지를 결정한다. |
| **차 동작** | 자동차 이동 | 이동 가능 조건을 만족하면 자동차의 위치를 1 증가시킨다. |
| 게임 진행  | 라운드 실행 | 사용자가 입력한 시도 횟수 만큼 경주를 반복 실행한다. |
| 게임 진행 | 최종 우승자 계산 | 모든 라운드가 끝난 후, 자동차들 중 가장 멀리 이동한 자동차를 찾는다.  |
| 게임 진행  | 라운드 결과 저장 | 매 라운드마다 자동차들의 이동 결과를 DTO에 저장한다.  |
| 출력 | 게임 시작 안내 | 게임 시작 시 “실행 결과”를 출력한다.  |
| **출력** | 현재 진행 상황 및 최종 우승자 출력 | 매 시도마다 각 자동차의 이동 결과를 출력한 후, 가장 멀리 이동한 자동차를 찾는다.  |

## 예외 처리


| 예외 상황 | 예외 타입 | 설명 |
| --- | --- | --- |
| 자동차 구분자가 쉼표가 아닐 때 | `IllegalArgumentException` | 구분자는 쉼표여야함 |
| 자동차 이름이 5글자 이상일 때 | `IllegalArgumentException` | 자동차 이름은 5글자 이하 |
| 반복 횟수가 숫자가 아닌 경우 | `IllegalArgumentException` | 반복 횟수는 숫자 |
| 반복 횟수가 음수, 0인 경우 | `IllegalArgumentException` | 반복 횟수는 양수 |
| 자동차 입력이 비어있는 경우 | `IllegalArgumentException` | 자동차 입력은 한 글자 이상 |
| 반복 횟수가 비어있는 경우  | `IllegalArgumentException` | 반복 횟수 입력은 필수 |
| 쉼표가 연속으로 들어올 때 | `IllegalArgumentException` | 쉼표 사이 비어 있는 이름은 허용하지 않음 (예: `pobi,,woni`) |
| 자동차 이름이 중복될 때 | `IllegalArgumentException` | 자동차 이름은 반복되면 안된다.  |
| 자동차 이름이 없을 때 | `IllegalArgumentException` | 자동차 이름은 1글자 이상이어야한다. |
| 자동차 이름에 허용되지 않은 문자가 포함 된 경우 | `IllegalArgumentException` | 자동차 이름은 한글, 영어, 숫자, 공백만 허용한다. |

## 핵심 설계 및 고민 과정


### 1️⃣ Getter 최소화

“객체에게 정보를 묻지 말고 행동을 시키라”라는 원칙을 적용하려 노력했다. 

`Car` 내부에서 `toString()`을 이용해 출력 시 Getter를 쓰지 않도록 설계했고, 내부 로직에서는 `isWinner()` 메서드로 상태를 스스로 판단하도록 했다.

또한 `Cars`에서는 `List`를 직접 노출하지 않고, `Iterator`를 통해 캡슐화를 지킬 수 있었다.

`Getter`가 불가피한 상황이 있어, 같은 모델 계층 내**(Cars → Car)** 에서만 `Getter` 사용을 허용했다.

### 2️⃣ 입력 검증 및 예외 처리 설계

- 동명이인
    
    출력 시 이름만 표시되므로, 복잡한 후처리 대신 동명이인 예외 처리로 단순화했다.
    
- 공백 처리
    
    `trim()`으로 양쪽 공백을 제거했고, 제거 후 빈 문자열은 리스트에서 제외했다. 공백 제거 후 글자 수를 다시 검증하도록 로직을 추가했다. 
    

### 3️⃣ Controller에 비즈니스 로직 제거

```java
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
        for (int i = 0; i < tryCountValue; i++) {
            racingGameService.playRound(cars);
            OutputView.printRoundResult(cars);
        }

        Winners winners = cars.findWinners();
        OutputView.printWinners(winners);
    }
```

처음에는 `Controller` 내부의 `for`문(게임 라운드 실행)을 `Service`로 위임할지 고민했다. 하지만 `Service` 계층에 `OutputView`가 포함되어 비즈니스 로직과 UI 로직이 섞이는 문제가 생긴다.

결국 `Controller`에 반복 구조를 남기되, 라운드 게임 로직은 `Service` 계층으로 위임하는 구조로 결정했다. 

### DTO (**Data Transfer Object**)

이 과정에서 **Controller와 Service 간에 라운드별 누적 정보를 DTO로 주고받을 수 있다면**, View 로직과 비즈니스 로직을 완전히 분리할 수 있다는 점을 깨달았다.

### WinnerResponse

```java
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
```

- 우승자 정보를 담는 객체로, `toString()`을 통해 “최종 우승자 : [이름]” 형태로 결과를 반환한다.

### GameRoundResponse

```java
public class GameRoundResponse {
    private final List<List<String>> gameRounds;

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
```

- 각 라운드별 게임 결과를 담는 DTO로, 2차원 리스트 형태로 라운드별 정보를 누적 저장한다.
- `toString()`을 통해 라운드 간 구분이 명확한 문자열 형태로 반환한다.

### GameResponse

```java
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
```

- `GameRoundResponse`와 `WinnersResponse`를 하나로 묶어 게임 전체 결과를 표현하는 DTO이다.
- `toString()`으로 두 DTO의 정보를 통합하여 출력한다.

### MVC A**rchitecture**

1주차 프리코스에서는 명확한 계층 구조가 없었기 때문에, 각 기능 모듈들이 서로 흩어져 있고 역할 구분이 모호했다. 그래서 프로그램의 전체 흐름을 한 곳에서 관리하기 위해 **Facade 패턴**을 적용했다.

2주차부터는 Controller가 점점 비대해지는 문제를 해결하기 위해 **Service 계층을 새로 추가**했다.

Service 계층 도입 후에는 비즈니스 로직이 Controller에서 분리되며 **각 계층의 역할이 명확히 구분**되었다.

특히 이번 주에는 리뷰어가 코드를 빠르게 이해할 수 있도록 “책임이 분명한 구조”를 목표로 삼았다.

MVC 패턴을 적용한 결과, **View는 입·출력 담당, Service는 비즈니스 로직 담당, Model은 데이터와 상태 관리 담당**으로 역할이 구체적으로 나뉘어 코드의 흐름이 한눈에 들어오고, 로직의 위치를 쉽게 추적할 수 있게 되었다.