package com.appsflyer.internal;

public final class bz {
    public static char[] valueOf(long j11, char[] cArr) {
        int length = cArr.length;
        char[] cArr2 = new char[length];
        int i11 = 4;
        int i12 = 0;
        for (int i13 = 0; i13 < cArr.length; i13++) {
            if ((((j11 >>> i13) & 1) != 1 || i12 >= 4) && i11 < length) {
                cArr2[i11] = cArr[i13];
                i11++;
            } else {
                cArr2[i12] = cArr[i13];
                i12++;
            }
        }
        return cArr2;
    }
}
