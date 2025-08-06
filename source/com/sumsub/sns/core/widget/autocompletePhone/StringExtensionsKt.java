package com.sumsub.sns.core.widget.autocompletePhone;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0002*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"maskLength", "", "", "getMaskLength", "(Ljava/lang/String;)I", "maskNumbers", "getMaskNumbers", "(Ljava/lang/String;)Ljava/lang/String;", "idensic-mobile-sdk-aar_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class StringExtensionsKt {
    public static final int getMaskLength(String str) {
        return getMaskNumbers(str).length();
    }

    public static final String getMaskNumbers(String str) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (Character.isDigit(charAt) || charAt == '#') {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }
}
