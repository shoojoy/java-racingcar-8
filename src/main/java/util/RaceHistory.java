package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;

public final class RaceHistory {
    private RaceHistory() {}

    public static List<Map<String, Integer>> runWithHistory(List<String> names, int tryCount) {
        return runWithHistory(names, tryCount, () -> Randoms.pickNumberInRange(0, 9));
    }

    /** 테스트/주입용  */
    public static List<Map<String, Integer>> runWithHistory(
            List<String> names, int tryCount, IntSupplier rng) {

        Map<String, Integer> cur = new LinkedHashMap<>();
        for (String n : names) cur.put(n, 0);

        List<Map<String, Integer>> history = new ArrayList<>();

        for (int t = 0; t < tryCount; t++) {
            for (String n : names) {
                int v = rng.getAsInt();
                if (MoveDecider.isMovable(v)) {
                    cur.put(n, cur.get(n) + 1);
                }
            }
            // 스냅샷(순서 유지)
            Map<String, Integer> snapshot = new LinkedHashMap<>(cur);
            history.add(snapshot);
        }
        return history;
    }
}
