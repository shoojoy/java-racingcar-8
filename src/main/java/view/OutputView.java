package view;

public class OutputView {
    public static final String NAME_PROMPT =
            "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_COUNT_PROMPT =
            "시도할 횟수는 몇 회인가요?";

    public void printNamePrompt() {
        System.out.println(NAME_PROMPT);
    }

    public void printTryCountPrompt() {
        System.out.println(TRY_COUNT_PROMPT);
    }
}
