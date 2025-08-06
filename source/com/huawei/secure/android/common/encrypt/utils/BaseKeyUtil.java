package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import ig.a;

public class BaseKeyUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38636a = "BaseKeyUtil";

    public static int a(int i11, int i12, int i13) {
        if (i12 < i11) {
            i11 = i12;
        }
        return i13 < i11 ? i13 : i11;
    }

    public static boolean b(int i11) {
        return i11 >= 16;
    }

    public static boolean c(int i11, byte[] bArr) {
        return b(i11) & d(bArr);
    }

    public static boolean d(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static byte[] e(String str, String str2, String str3, String str4, int i11, boolean z11) {
        return g(str, str2, str3, a.b(str4), i11, z11);
    }

    public static byte[] f(String str, String str2, String str3, byte[] bArr, int i11, int i12, boolean z11) {
        byte[] b11 = a.b(str);
        byte[] b12 = a.b(str2);
        byte[] b13 = a.b(str3);
        int a11 = a(b11.length, b12.length, b13.length);
        if (c(a11, bArr)) {
            char[] cArr = new char[a11];
            for (int i13 = 0; i13 < a11; i13++) {
                cArr[i13] = (char) ((b11[i13] ^ b12[i13]) ^ b13[i13]);
            }
            if (!z11) {
                b.d(f38636a, "exportRootKey: sha1");
                return PBKDF2.b(cArr, bArr, i11, i12 * 8);
            }
            b.d(f38636a, "exportRootKey: sha256");
            return PBKDF2.c(cArr, bArr, i11, i12 * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    @SuppressLint({"NewApi"})
    public static byte[] g(String str, String str2, String str3, byte[] bArr, int i11, boolean z11) {
        return f(str, str2, str3, bArr, 10000, i11, z11);
    }

    @SuppressLint({"NewApi"})
    public static byte[] h(String str, String str2, String str3, byte[] bArr, boolean z11) {
        return g(str, str2, str3, bArr, 16, z11);
    }
}
