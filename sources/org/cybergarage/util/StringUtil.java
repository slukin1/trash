package org.cybergarage.util;

public final class StringUtil {
    public static final boolean a(String str) {
        return str != null && str.length() > 0;
    }

    public static final long b(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e11) {
            Debug.d(e11);
            return 0;
        }
    }
}
