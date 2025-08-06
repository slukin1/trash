package com.ytjojo.shadowlayout.utils;

import android.content.Context;

public class DisplayUtils {
    public static int a(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
