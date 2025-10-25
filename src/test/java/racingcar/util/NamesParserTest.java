package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NamesParser;

class NamesParserTest {

    @Test
    @DisplayName("쉼표로 분리하고 각 토큰을 trim 한다")
    void splitsByCommaAndTrims() {
        String raw = "pobi, woni,  jun";

        List<String> names = NamesParser.parse(raw);

        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("중간에 빈 토큰이 있어도 보존한다(검증은 다음 단계)")
    void preservesEmptyToken() {
        String raw = "pobi,,woni";

        List<String> names = NamesParser.parse(raw);

        assertThat(names).containsExactly("pobi", "", "woni");
    }

    @Test
    @DisplayName("앞뒤 공백만 있는 토큰도 trim 후 보존한다")
    void trimsWhitespaceOnlyToken() {
        String raw = "  pobi  ,   , woni  ";

        List<String> names = NamesParser.parse(raw);

        assertThat(names).containsExactly("pobi", "", "woni");
    }
}
