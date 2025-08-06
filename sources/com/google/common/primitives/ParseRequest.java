package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class ParseRequest {
    public final int radix;
    public final String rawValue;

    private ParseRequest(String str, int i11) {
        this.rawValue = str;
        this.radix = i11;
    }

    public static ParseRequest fromString(String str) {
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            int i11 = 16;
            if (str.startsWith("0x") || str.startsWith("0X")) {
                str = str.substring(2);
            } else if (charAt == '#') {
                str = str.substring(1);
            } else if (charAt != '0' || str.length() <= 1) {
                i11 = 10;
            } else {
                str = str.substring(1);
                i11 = 8;
            }
            return new ParseRequest(str, i11);
        }
        throw new NumberFormatException("empty string");
    }
}
