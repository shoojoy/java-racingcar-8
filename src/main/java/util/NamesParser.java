package util;

import java.util.Arrays;
import java.util.List;

public final class NamesParser {
    private NamesParser() {}

    public static List<String> parse(String raw) {
        if (raw == null) {
            // NPE 방지용 최소 처리 (검증은 다음 단계에서 다룸)
            return List.of("");
        }
        // -1 옵션으로 중간/끝의 빈 토큰까지 보존
        return Arrays.stream(raw.split(",", -1))
                .map(String::trim)
                .toList();
    }
}
