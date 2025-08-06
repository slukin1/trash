package com.iproov.sdk.p017implements;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.iproov.sdk.implements.if  reason: invalid class name and invalid package */
public class Cif {
    /* renamed from: do  reason: not valid java name */
    public static byte[] m1010do(byte[] bArr, List<byte[]> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bArr);
        arrayList.addAll(list);
        return m1011do((byte[][]) arrayList.toArray(new byte[arrayList.size()][]));
    }

    /* renamed from: do  reason: not valid java name */
    public static byte[] m1011do(byte[]... bArr) {
        int i11 = 0;
        for (byte[] length : bArr) {
            i11 += length.length;
        }
        byte[] bArr2 = new byte[i11];
        int i12 = 0;
        for (byte[] bArr3 : bArr) {
            int length2 = bArr3.length;
            System.arraycopy(bArr3, 0, bArr2, i12, length2);
            i12 += length2;
        }
        return bArr2;
    }

    /* renamed from: do  reason: not valid java name */
    public static byte[] m1009do(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr2[(bArr.length - i11) - 1] = bArr[i11];
        }
        return bArr2;
    }
}
