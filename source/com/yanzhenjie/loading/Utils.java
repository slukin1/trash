package com.yanzhenjie.loading;

import android.content.Context;

public class Utils {
    public static float a(Context context, float f11) {
        return (float) ((((double) context.getResources().getDisplayMetrics().density) + 0.5d) * ((double) f11));
    }
}
