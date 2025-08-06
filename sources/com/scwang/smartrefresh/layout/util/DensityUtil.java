package com.scwang.smartrefresh.layout.util;

import android.content.res.Resources;

public class DensityUtil {

    /* renamed from: a  reason: collision with root package name */
    public float f29938a = Resources.getSystem().getDisplayMetrics().density;

    public static int b(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static float c(int i11) {
        return ((float) i11) / Resources.getSystem().getDisplayMetrics().density;
    }

    public int a(float f11) {
        return (int) ((f11 * this.f29938a) + 0.5f);
    }
}
