package com.huochat.community.util;

import android.os.SystemClock;

public class ClickTool {
    private static final int CLICK_SPAN = 700;
    public static long sLastClickTime;

    public static boolean isRealClick() {
        return isRealClick(CLICK_SPAN);
    }

    public static boolean isRealClick(int i11) {
        if (SystemClock.elapsedRealtime() - sLastClickTime < ((long) i11)) {
            return false;
        }
        sLastClickTime = SystemClock.elapsedRealtime();
        return true;
    }
}
