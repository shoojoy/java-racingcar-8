package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;

public final class GameLoop {
    private GameLoop() {}

    public static Map<String, Integer> run(List<String> names, int tryCount) {
        return run(names, tryCount, () -> Randoms.pickNumberInRange(0, 9));
    }

    public static Map<String, Integer> run(List<String> names, int tryCount, IntSupplier rng) {
        Map<String, Integer> pos = new LinkedHashMap<>();
        for (String n : names) pos.put(n, 0);

        for (int t = 0; t < tryCount; t++) {
            for (String n : names) {
                int v = rng.getAsInt();
                if (MoveDecider.isMovable(v)) {
                    pos.put(n, pos.get(n) + 1);
                }
            }
        }
        return pos; // 이후 단계에서 출력/우승자 계산에 사용
    }
}
