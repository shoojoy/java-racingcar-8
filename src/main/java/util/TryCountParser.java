package util;

public final class TryCountParser {
    private TryCountParser() { }

    public static int parse(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("시도 횟수는 null일 수 없습니다.");
        }
        String trimmed = raw.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 비어있을 수 없습니다.");
        }
        try {
            int n = Integer.parseInt(trimmed);
            if (n < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return n;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }
}
