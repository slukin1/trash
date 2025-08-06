package com.huawei.secure.android.common.util;

public class EncodeUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f38660a = {',', '.', '-', '_'};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f38661b = new String[256];

    static {
        for (char c11 = 0; c11 < 255; c11 = (char) (c11 + 1)) {
            if ((c11 < '0' || c11 > '9') && ((c11 < 'A' || c11 > 'Z') && (c11 < 'a' || c11 > 'z'))) {
                f38661b[c11] = a(c11).intern();
            } else {
                f38661b[c11] = null;
            }
        }
    }

    public static String a(char c11) {
        return Integer.toHexString(c11);
    }
}
