package com.appsflyer.internal;

public final class cb {
    public static long[] values(int i11, int i12) {
        long[] jArr = new long[4];
        jArr[0] = (((long) i12) & 4294967295L) | ((((long) i11) & 4294967295L) << 32);
        for (int i13 = 1; i13 < 4; i13++) {
            long j11 = jArr[i13 - 1];
            jArr[i13] = ((j11 ^ (j11 >> 30)) * 1812433253) + ((long) i13);
        }
        return jArr;
    }
}
