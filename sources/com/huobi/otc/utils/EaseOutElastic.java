package com.huobi.otc.utils;

import android.animation.TimeInterpolator;

public class EaseOutElastic implements TimeInterpolator {
    public float getInterpolation(float f11) {
        return (-f11) * (f11 - 2.0f);
    }
}
