package racingcar;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
            OutputView out = new OutputView();
            InputView in = new InputView();

            out.printNamePrompt();
            String namesRaw = in.readLine();

            out.printTryCountPrompt();
            String tryCountRaw = in.readLine();
    }
}
