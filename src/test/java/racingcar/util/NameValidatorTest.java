package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NameValidator;

class NameValidatorTest {

    @Test
    @DisplayName("정상 이름은 통과한다 (1~5자, 공백 없음)")
    void validNamesPass() {
        assertThatCode(() -> {
            NameValidator.validate("pobi");
            NameValidator.validate("woni");
            NameValidator.validate("jun");
            NameValidator.validate("a");      // 1자
            NameValidator.validate("abcde");  // 5자
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("빈 문자열 또는 공백-only는 거부한다")
    void blankIsRejected() {
        assertThatThrownBy(() -> NameValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NameValidator.validate("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("길이 6자 이상은 거부한다")
    void tooLongIsRejected() {
        assertThatThrownBy(() -> NameValidator.validate("javaji")) // 6
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 내부에 공백이 포함되면 거부한다")
    void innerWhitespaceIsRejected() {
        assertThatThrownBy(() -> NameValidator.validate("po bi"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NameValidator.validate("po\tbi"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NameValidator.validate("po\nbi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
