package com.hbg.lib.common.utils.crypt.rsa;

public class ArrayUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f67559a = new byte[0];

    public static byte[] a(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return b(bArr2);
        }
        if (bArr2 == null) {
            return b(bArr);
        }
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static byte[] c(byte[] bArr, int i11, int i12) {
        if (bArr == null) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i12 > bArr.length) {
            i12 = bArr.length;
        }
        int i13 = i12 - i11;
        if (i13 <= 0) {
            return f67559a;
        }
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, i11, bArr2, 0, i13);
        return bArr2;
    }
}
