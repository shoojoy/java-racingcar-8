package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.MoveDecider;

class MoveDeciderTest {

    @Test
    @DisplayName("값이 4 이상이면 전진(true)")
    void moveWhenGte4() {
        assertThat(MoveDecider.isMovable(4)).isTrue();
        assertThat(MoveDecider.isMovable(9)).isTrue();
    }

    @Test
    @DisplayName("값이 3 이하면 정지(false)")
    void stayWhenLte3() {
        assertThat(MoveDecider.isMovable(3)).isFalse();
        assertThat(MoveDecider.isMovable(0)).isFalse();
    }
}
