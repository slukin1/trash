package com.hbg.component.kline.utils;

import i6.m;

public class NumberKlineUtil {
    public static String a(double d11, int i11, boolean z11) {
        return m.k(d11, i11, z11);
    }

    public static String b(double d11, int i11) {
        String str = d11 > 0.0d ? "+" : "";
        String d12 = d(d11 * 100.0d, i11);
        return str + d12 + "%";
    }

    public static boolean c(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        return str.matches("^(-?\\d+)(\\.\\d+)?$");
    }

    public static String d(double d11, int i11) {
        return a(d11, i11, false);
    }

    public static String e(double d11, int i11) {
        String str = d11 > 0.0d ? "+" : "";
        return str + d(d11, i11);
    }

    public static boolean f(double d11) {
        return d11 != 0.0d && !Double.isNaN(d11);
    }

    public static boolean g(double d11) {
        return !Double.isNaN(d11);
    }
}
