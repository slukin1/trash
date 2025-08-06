package com.google.android.datatransport.cct;

public final class StringMerger {
    public static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length());
        for (int i11 = 0; i11 < str.length(); i11++) {
            sb2.append(str.charAt(i11));
            if (str2.length() > i11) {
                sb2.append(str2.charAt(i11));
            }
        }
        return sb2.toString();
    }
}
