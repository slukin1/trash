package com.facebook.stetho.websocket;

class MaskingHelper {
    public static void unmask(byte[] bArr, byte[] bArr2, int i11, int i12) {
        int i13 = 0;
        while (true) {
            int i14 = i12 - 1;
            if (i12 > 0) {
                bArr2[i11] = (byte) (bArr[i13 % bArr.length] ^ bArr2[i11]);
                i11++;
                i12 = i14;
                i13++;
            } else {
                return;
            }
        }
    }
}
