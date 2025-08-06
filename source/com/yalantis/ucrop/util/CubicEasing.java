package com.yalantis.ucrop.util;

public final class CubicEasing {
    public static float easeIn(float f11, float f12, float f13, float f14) {
        float f15 = f11 / f14;
        return (f13 * f15 * f15 * f15) + f12;
    }

    public static float easeInOut(float f11, float f12, float f13, float f14) {
        float f15;
        float f16 = f11 / (f14 / 2.0f);
        float f17 = f13 / 2.0f;
        if (f16 < 1.0f) {
            f15 = f17 * f16 * f16 * f16;
        } else {
            float f18 = f16 - 2.0f;
            f15 = f17 * ((f18 * f18 * f18) + 2.0f);
        }
        return f15 + f12;
    }

    public static float easeOut(float f11, float f12, float f13, float f14) {
        float f15 = (f11 / f14) - 1.0f;
        return (f13 * ((f15 * f15 * f15) + 1.0f)) + f12;
    }
}
