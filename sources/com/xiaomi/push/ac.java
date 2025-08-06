package com.xiaomi.push;

import android.content.Context;

public class ac {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f51355a = "0123456789ABCDEF".toCharArray();

    public static boolean a(Context context) {
        return ab.f51354a;
    }

    public static String a(byte[] bArr, int i11, int i12) {
        StringBuilder sb2 = new StringBuilder(i12 * 2);
        for (int i13 = 0; i13 < i12; i13++) {
            byte b11 = bArr[i11 + i13] & 255;
            char[] cArr = f51355a;
            sb2.append(cArr[b11 >> 4]);
            sb2.append(cArr[b11 & 15]);
        }
        return sb2.toString();
    }
}
