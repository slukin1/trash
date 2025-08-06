package com.nineoldandroids.animation;

import fx.c;

public class ArgbEvaluator implements c {
    public Object evaluate(float f11, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        int i11 = intValue >> 24;
        int i12 = (intValue >> 16) & 255;
        int i13 = (intValue >> 8) & 255;
        int i14 = intValue & 255;
        int intValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf(((i11 + ((int) (((float) ((intValue2 >> 24) - i11)) * f11))) << 24) | ((i12 + ((int) (((float) (((intValue2 >> 16) & 255) - i12)) * f11))) << 16) | ((i13 + ((int) (((float) (((intValue2 >> 8) & 255) - i13)) * f11))) << 8) | (i14 + ((int) (f11 * ((float) ((intValue2 & 255) - i14))))));
    }
}
