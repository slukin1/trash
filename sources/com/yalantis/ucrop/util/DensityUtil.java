package com.yalantis.ucrop.util;

import android.content.Context;
import android.content.res.Resources;

public class DensityUtil {
    public static int dip2px(Context context, float f11) {
        return (int) ((f11 * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize == 0 ? dip2px(context, 26.0f) : dimensionPixelSize;
    }
}
