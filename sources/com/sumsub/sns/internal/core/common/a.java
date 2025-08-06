package com.sumsub.sns.internal.core.common;

import android.app.Activity;
import android.content.res.TypedArray;

public final class a {
    public static final int a(Activity activity, int i11) {
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{i11});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    public static final int b(Activity activity, int i11) {
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{i11});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }
}
