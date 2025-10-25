package racingcar;

import java.util.List;
import java.util.Map;
import util.NameValidator;
import util.NamesParser;
import util.TryCountParser;
import view.InputView;
import view.OutputView;
import util.GameLoop;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
            OutputView out = new OutputView();
            InputView in = new InputView();

        // 1) 입력
            out.printNamePrompt();
            String namesRaw = in.readLine();

            out.printTryCountPrompt();
            String tryCountRaw = in.readLine();

        // 2) 파싱
            List<String> names = NamesParser.parse(namesRaw);

        // 3) 검증 (위반 시 IllegalArgumentException 발생 → 프로그램 종료)
            names.forEach(NameValidator::validate);
            int tryCount = TryCountParser.parse(tryCountRaw);
        // 4) 게임 루프 실행 (시도 횟수만큼 이동 규칙 적용)
            Map<String, Integer> positions = GameLoop.run(names, tryCount);
    }
}
