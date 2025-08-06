package com.wtree.helper;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.BaseApplication;

public class Utils {
    public static int a(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(int i11) {
        return (int) BaseApplication.b().getResources().getDimension(i11);
    }

    public static Typeface c(int i11) {
        return Typeface.create(ResourcesCompat.h(BaseApplication.b(), i11), 0);
    }
}
