package com.huobi.view.collapsingtoolbarlayout;

class MathUtils {
    public static float constrain(float f11, float f12, float f13) {
        return f11 < f12 ? f12 : f11 > f13 ? f13 : f11;
    }

    public static int constrain(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : i11 > i13 ? i13 : i11;
    }
}
