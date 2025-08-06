package com.appsflyer.internal;

public final class by {
    public static void AFInAppEventParameterName(char[] cArr, char c11, char c12, char c13, char c14) {
        char c15 = 58224;
        for (int i11 = 0; i11 < 16; i11++) {
            cArr[1] = (char) (cArr[1] - (((cArr[0] + c15) ^ ((cArr[0] << 4) + c13)) ^ ((cArr[0] >>> 5) + c14)));
            cArr[0] = (char) (cArr[0] - (((cArr[1] >>> 5) + c12) ^ ((cArr[1] + c15) ^ ((cArr[1] << 4) + c11))));
            c15 = (char) (c15 - 40503);
        }
    }
}
