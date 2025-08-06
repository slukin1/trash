package com.luck.picture.lib.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.sumsub.sns.internal.core.analytics.d;

public class ValueOf {
    public static <T> T to(Object obj, T t11) {
        return obj == null ? t11 : obj;
    }

    public static boolean toBoolean(Object obj) {
        return toBoolean(obj, false);
    }

    public static double toDouble(Object obj) {
        return toDouble(obj, 0);
    }

    public static float toFloat(Object obj, long j11) {
        if (obj == null) {
            return (float) j11;
        }
        try {
            return Float.parseFloat(obj.toString().trim());
        } catch (Exception unused) {
            return (float) j11;
        }
    }

    public static int toInt(Object obj, int i11) {
        int i12;
        if (obj == null) {
            return i11;
        }
        try {
            String trim = obj.toString().trim();
            if (trim.contains(InstructionFileId.DOT)) {
                i12 = Integer.parseInt(trim.substring(0, trim.lastIndexOf(InstructionFileId.DOT)));
            } else {
                i12 = Integer.parseInt(trim);
            }
            return i12;
        } catch (Exception unused) {
            return i11;
        }
    }

    public static long toLong(Object obj, long j11) {
        long j12;
        if (obj == null) {
            return j11;
        }
        try {
            String trim = obj.toString().trim();
            if (trim.contains(InstructionFileId.DOT)) {
                j12 = Long.parseLong(trim.substring(0, trim.lastIndexOf(InstructionFileId.DOT)));
            } else {
                j12 = Long.parseLong(trim);
            }
            return j12;
        } catch (Exception unused) {
            return j11;
        }
    }

    public static String toString(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean toBoolean(Object obj, boolean z11) {
        if (obj == null) {
            return false;
        }
        try {
            return !d.f31895b.equals(obj.toString().trim().trim());
        } catch (Exception unused) {
            return z11;
        }
    }

    public static double toDouble(Object obj, int i11) {
        if (obj == null) {
            return (double) i11;
        }
        try {
            return Double.parseDouble(obj.toString().trim());
        } catch (Exception unused) {
            return (double) i11;
        }
    }

    public static float toFloat(Object obj) {
        return toFloat(obj, 0);
    }

    public static int toInt(Object obj) {
        return toInt(obj, 0);
    }

    public static long toLong(Object obj) {
        return toLong(obj, 0);
    }
}
