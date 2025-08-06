package com.sumsub.sns.internal.core.common;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;

public final class m {
    public static final void a(Drawable drawable, int i11) {
        ColorFilter colorFilter;
        if (Build.VERSION.SDK_INT >= 29) {
            colorFilter = new BlendModeColorFilter(i11, BlendMode.SRC_ATOP);
        } else {
            colorFilter = new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_ATOP);
        }
        drawable.setColorFilter(colorFilter);
    }
}
