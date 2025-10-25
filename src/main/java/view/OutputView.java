package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String NAME_PROMPT =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_COUNT_PROMPT =
            "시도할 횟수는 몇 회인가요?";

    public void printNamePrompt() {
        System.out.println(NAME_PROMPT);
    }

    public void printTryCountPrompt() {
        System.out.println(TRY_COUNT_PROMPT);
    }

    public void printExecutionHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRound(Map<String, Integer> positions) {
        for (Map.Entry<String, Integer> e : positions.entrySet()) {
            System.out.println(e.getKey() + " : " + "-".repeat(e.getValue()));
        }
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
