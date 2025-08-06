package com.huobi.woodpecker.utils;

public class NumberUtil {
    public static Long a(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int b(int i11) {
        return (int) Math.pow(10.0d, (double) i11);
    }

    public static double c(float f11, int i11) {
        int b11 = b(i11);
        return (((double) Math.round(f11 * ((float) b11))) / 1.0d) / ((double) b11);
    }

    public static Integer d(Object obj, Integer num) {
        try {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            if (obj instanceof Number) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            if (obj instanceof CharSequence) {
                return Integer.valueOf(obj.toString());
            }
            return num;
        } catch (Exception unused) {
        }
    }
}
