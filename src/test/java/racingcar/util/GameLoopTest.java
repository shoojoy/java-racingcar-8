package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.function.IntSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.GameLoop;

class GameLoopTest {

    static class SeqRng implements IntSupplier {
        private final Queue<Integer> q = new ArrayDeque<>();
        SeqRng(Integer... seq) { q.addAll(Arrays.asList(seq)); }
        @Override public int getAsInt() { return q.remove(); }
    }

    @Test
    @DisplayName("2대, 2회 — 각 차에 대해 라운드별 랜덤을 소비하고 4 이상이면 전진")
    void twoCarsTwoRounds() {
        List<String> names = List.of("pobi", "woni");
        SeqRng rng = new SeqRng(4, 3, 3, 4);

        Map<String, Integer> pos = GameLoop.run(names, 2, rng);

        assertThat(pos).containsEntry("pobi", 1)
                .containsEntry("woni", 1);
    }

    @Test
    @DisplayName("한 대, 3회 — 4 이상만 전진")
    void oneCarThreeRounds() {
        List<String> names = List.of("jun");
        SeqRng rng = new SeqRng(4, 2, 9); // T, F, T → +2

        Map<String, Integer> pos = GameLoop.run(names, 3, rng);

        assertThat(pos.get("jun")).isEqualTo(2);
    }
}
