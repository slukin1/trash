package com.jumio.commons.utils;

import android.content.Context;
import android.util.TypedValue;

public class ScreenUtil {
    public static float dipToPx(Context context, float f11) {
        return TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics());
    }

    public static int dpToPx(Context context, int i11) {
        return (int) TypedValue.applyDimension(1, (float) i11, context.getResources().getDisplayMetrics());
    }

    public static int pxToDp(Context context, int i11) {
        return (int) (((float) i11) / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static float spToPx(Context context, float f11) {
        return TypedValue.applyDimension(2, f11, context.getResources().getDisplayMetrics());
    }

    public static int dpToPx(Context context, float f11) {
        return (int) TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics());
    }

    public static int pxToDp(Context context, float f11) {
        return ((int) f11) / (context.getResources().getDisplayMetrics().densityDpi / 160);
    }
}
