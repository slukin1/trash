package com.iproov.sdk.p035try;

import java.util.Locale;

/* renamed from: com.iproov.sdk.try.for  reason: invalid class name and invalid package */
public class Cfor {
    /* renamed from: do  reason: not valid java name */
    public static String m2132do(Float f11) {
        return m2133if(Double.valueOf((double) f11.floatValue()));
    }

    /* renamed from: if  reason: not valid java name */
    public static String m2133if(Double d11) {
        if (d11 == null) {
            d11 = Double.valueOf(-1.0d);
        }
        return String.format(Locale.getDefault(), "%.3f", new Object[]{d11});
    }

    /* renamed from: do  reason: not valid java name */
    public static String m2131do(Double d11) {
        if (d11 == null) {
            d11 = Double.valueOf(0.0d);
        }
        return Math.abs(d11.doubleValue() - 1.0d) < 0.1d ? "T" : "F";
    }
}
