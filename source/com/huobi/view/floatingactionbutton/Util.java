package com.huobi.view.floatingactionbutton;

import android.os.Build;

final class Util {
    private Util() {
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
