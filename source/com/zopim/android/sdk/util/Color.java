package com.zopim.android.sdk.util;

import android.content.Context;
import android.util.TypedValue;
import com.zopim.android.sdk.R;

public class Color {
    public static int getThemeAccentColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        return typedValue.data;
    }
}
