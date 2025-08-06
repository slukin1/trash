package com.sumsub.sns.internal.core.common;

public final class w0 {
    public static final String a(String str, int i11) {
        boolean z11 = true;
        if (str.length() == 0) {
            return str;
        }
        String substring = str.substring(0, RangesKt___RangesKt.g(i11, str.length()));
        if (substring.length() != str.length()) {
            z11 = false;
        }
        if (!z11) {
            str = null;
        }
        if (str != null) {
            return str;
        }
        return substring + " ...";
    }
}
