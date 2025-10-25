package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import util.MoveDecider;
import util.NameValidator;
import util.NamesParser;
import util.TryCountParser;
import view.InputView;
import view.OutputView;

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

            out.printExecutionHeader();

        // 4) 게임 루프 실행 (시도 횟수만큼 이동 규칙 적용)
            Map<String, Integer> positions = new LinkedHashMap<>();
            for (String n : names) positions.put(n, 0); // 입력 순서 유지

            for (int t = 0; t < tryCount; t++) {
                    for (String n : names) {
                            if (MoveDecider.shouldMove()) {
                                    positions.put(n, positions.get(n) + 1);
                            }
                    }
                    out.printRound(positions);
                    if (t < tryCount - 1) out.printEmptyLine(); // 라운드 사이 빈 줄 1개
            }

            // 6) 우승자 계산 및 출력
            int max = positions.values().stream().mapToInt(i -> i).max().orElse(0);
            List<String> winners = new ArrayList<>();
            for (String n : names) {
                    if (positions.get(n) == max) winners.add(n);
            }
            out.printEmptyLine();
            out.printWinners(winners);

    }
}
