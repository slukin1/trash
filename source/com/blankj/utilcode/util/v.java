package com.blankj.utilcode.util;

import android.content.res.Resources;

public final class v {
    public static int a(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
