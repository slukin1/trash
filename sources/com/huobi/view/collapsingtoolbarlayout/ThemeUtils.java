package com.huobi.view.collapsingtoolbarlayout;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.appcompat.R$attr;

class ThemeUtils {
    private static final int[] APPCOMPAT_CHECK_ATTRS = {R$attr.colorPrimary};

    public static void checkAppCompatTheme(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        boolean z11 = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (z11) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
