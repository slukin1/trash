package com.alibaba.fastjson.util;

import java.util.Arrays;

public class Base64 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f14399a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f14400b;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f14399a = charArray;
        int[] iArr = new int[256];
        f14400b = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i11 = 0; i11 < length; i11++) {
            f14400b[f14399a[i11]] = i11;
        }
        f14400b[61] = 0;
    }
}
