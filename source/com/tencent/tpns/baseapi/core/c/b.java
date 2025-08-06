package com.tencent.tpns.baseapi.core.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f49877a = "0123456789abcdef".toCharArray();

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            char[] cArr = f49877a;
            sb2.append(cArr[(b11 >> 4) & 15]);
            sb2.append(cArr[b11 & 15]);
        }
        return sb2.toString();
    }
}
