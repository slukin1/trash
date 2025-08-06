package com.tencent.qcloud.tuikit.tuichat.util;

public class AngleUtil {
    public static int getSensorAngle(float f11, float f12) {
        if (Math.abs(f11) <= Math.abs(f12)) {
            return (f12 <= 7.0f && f12 < -7.0f) ? 180 : 0;
        }
        if (f11 > 4.0f) {
            return 270;
        }
        return f11 < -4.0f ? 90 : 0;
    }
}
