package com.nineoldandroids.animation;

import fx.c;

public class IntEvaluator implements c<Integer> {
    /* renamed from: a */
    public Integer evaluate(float f11, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) (((float) intValue) + (f11 * ((float) (num2.intValue() - intValue)))));
    }
}
