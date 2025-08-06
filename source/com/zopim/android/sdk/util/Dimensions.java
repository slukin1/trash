package com.zopim.android.sdk.util;

import android.content.Context;
import android.util.TypedValue;

public class Dimensions {
    public static int convertDpToPixel(Context context, float f11) {
        return (int) TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics());
    }
}
