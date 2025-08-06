package com.tencent.android.tpush.service.channel.security;

import com.google.common.base.Ascii;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f69676a = true;

    /* renamed from: b  reason: collision with root package name */
    private int[] f69677b = new int[4];

    public e(byte[] bArr) {
        if (bArr == null) {
            throw new RuntimeException("Invalid key: Key was null");
        } else if (bArr.length >= 16) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < 4) {
                int[] iArr = this.f69677b;
                int i13 = i12 + 1;
                int i14 = i13 + 1;
                byte b11 = (bArr[i12] & 255) | ((bArr[i13] & 255) << 8);
                int i15 = i14 + 1;
                iArr[i11] = b11 | ((bArr[i14] & 255) << 16) | ((bArr[i15] & 255) << Ascii.CAN);
                i11++;
                i12 = i15 + 1;
            }
        } else {
            throw new RuntimeException("Invalid key: Length was less than 16 bytes");
        }
    }
}
