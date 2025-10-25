package util;

import camp.nextstep.edu.missionutils.Randoms;

public final class MoveDecider {
    private static final int THRESHOLD = 4;

    private MoveDecider() {}

    public static boolean shouldMove() {
        int value = Randoms.pickNumberInRange(0, 9);
        return isMovable(value);
    }

    public static boolean isMovable(int value) {
        return value >= THRESHOLD;
    }
}
