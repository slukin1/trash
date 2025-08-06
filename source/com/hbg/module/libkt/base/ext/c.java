package com.hbg.module.libkt.base.ext;

import android.content.res.Resources;
import com.hbg.lib.common.BaseApplication;

public final class c {
    public static final int a(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int b() {
        return BaseApplication.b().getResources().getDisplayMetrics().heightPixels;
    }

    public static final int c() {
        return BaseApplication.b().getResources().getDisplayMetrics().widthPixels;
    }

    public static final int d(Float f11) {
        return a(f11 != null ? f11.floatValue() : 0.0f);
    }

    public static final float e(Float f11) {
        return (float) a(f11 != null ? f11.floatValue() : 0.0f);
    }

    public static final int f(Float f11) {
        return j(f11 != null ? f11.floatValue() : 0.0f);
    }

    public static final int g(Float f11) {
        return i(f11 != null ? f11.floatValue() : 0.0f);
    }

    public static final int h(float f11) {
        return (int) ((f11 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int i(float f11) {
        return (int) ((f11 / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static final int j(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
