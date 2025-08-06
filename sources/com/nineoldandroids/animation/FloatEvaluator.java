package com.nineoldandroids.animation;

import fx.c;

public class FloatEvaluator implements c<Number> {
    /* renamed from: a */
    public Float evaluate(float f11, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f11 * (number2.floatValue() - floatValue)));
    }
}
