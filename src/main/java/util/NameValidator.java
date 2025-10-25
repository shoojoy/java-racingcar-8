package util;

public final class NameValidator {
    private static final int MAX_LEN = 5;

    private NameValidator() { }

    public static void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null일 수 없습니다.");
        }

        final String trimmed = name.trim();

        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 값일 수 없습니다.");
        }

        if (trimmed.length() > MAX_LEN) {
            throw new IllegalArgumentException("이름 길이는 1~5자여야 합니다.");
        }

        if (containsWhitespaceInside(trimmed)) {
            throw new IllegalArgumentException("이름에 공백 문자를 포함할 수 없습니다.");
        }
    }

    private static boolean containsWhitespaceInside(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
