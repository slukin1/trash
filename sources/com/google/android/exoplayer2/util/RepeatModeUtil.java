package com.google.android.exoplayer2.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RepeatModeUtil {
    public static final int REPEAT_TOGGLE_MODE_ALL = 2;
    public static final int REPEAT_TOGGLE_MODE_NONE = 0;
    public static final int REPEAT_TOGGLE_MODE_ONE = 1;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatToggleModes {
    }

    private RepeatModeUtil() {
    }

    public static int getNextRepeatMode(int i11, int i12) {
        for (int i13 = 1; i13 <= 2; i13++) {
            int i14 = (i11 + i13) % 3;
            if (isRepeatModeEnabled(i14, i12)) {
                return i14;
            }
        }
        return i11;
    }

    public static boolean isRepeatModeEnabled(int i11, int i12) {
        if (i11 == 0) {
            return true;
        }
        if (i11 == 1) {
            return (i12 & 1) != 0;
        }
        if (i11 != 2) {
            return false;
        }
        return (i12 & 2) != 0;
    }
}
