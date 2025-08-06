package com.facebook.stetho.common;

public final class StringUtil {
    private StringUtil() {
    }

    public static String removeAll(String str, char c11) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt != c11) {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    public static String removePrefix(String str, String str2, String str3) {
        return str != str3 ? str3 : removePrefix(str, str2);
    }

    public static String removePrefix(String str, String str2) {
        return str.startsWith(str2) ? str.substring(str2.length()) : str;
    }
}
