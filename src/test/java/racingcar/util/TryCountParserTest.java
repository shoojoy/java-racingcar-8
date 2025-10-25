package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TryCountParser;

class TryCountParserTest {

    @Test
    @DisplayName("정상 입력은 정수로 파싱되고 1 이상이어야 한다")
    void parseValidCounts() {
        assertThat(TryCountParser.parse("1")).isEqualTo(1);
        assertThat(TryCountParser.parse(" 3 ")).isEqualTo(3); // 앞뒤 공백 허용
    }

    @Test
    @DisplayName("0 또는 음수는 거부한다")
    void nonPositiveRejected() {
        assertThatThrownBy(() -> TryCountParser.parse("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TryCountParser.parse("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아니거나 비어있으면 거부한다")
    void nonNumericOrBlankRejected() {
        assertThatThrownBy(() -> TryCountParser.parse("a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TryCountParser.parse(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TryCountParser.parse("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
