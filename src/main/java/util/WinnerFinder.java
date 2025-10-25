package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class WinnerFinder {
    private WinnerFinder() {}

    public static List<String> findWinners(Map<String, Integer> finalPositions) {
        int max = finalPositions.values().stream().mapToInt(i -> i).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> e : finalPositions.entrySet()) {
            if (e.getValue() == max) winners.add(e.getKey());
        }
        return winners;
    }
}
