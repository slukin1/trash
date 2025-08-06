package com.alibaba.fastjson.asm;

import e2.d;

public class Label {

    /* renamed from: a  reason: collision with root package name */
    public int f14168a;

    /* renamed from: b  reason: collision with root package name */
    public int f14169b;

    /* renamed from: c  reason: collision with root package name */
    public int f14170c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f14171d;

    public final void a(int i11, int i12) {
        if (this.f14171d == null) {
            this.f14171d = new int[6];
        }
        int i13 = this.f14170c;
        int[] iArr = this.f14171d;
        if (i13 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 6)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f14171d = iArr2;
        }
        int[] iArr3 = this.f14171d;
        int i14 = this.f14170c;
        int i15 = i14 + 1;
        this.f14170c = i15;
        iArr3[i14] = i11;
        this.f14170c = i15 + 1;
        iArr3[i15] = i12;
    }

    public void b(d dVar, ByteVector byteVector, int i11) {
        if ((this.f14168a & 2) == 0) {
            a(i11, byteVector.f14149b);
            byteVector.g(-1);
            return;
        }
        byteVector.g(this.f14169b - i11);
    }

    public void c(d dVar, int i11, byte[] bArr) {
        this.f14168a |= 2;
        this.f14169b = i11;
        int i12 = 0;
        while (i12 < this.f14170c) {
            int[] iArr = this.f14171d;
            int i13 = i12 + 1;
            int i14 = iArr[i12];
            int i15 = iArr[i13];
            int i16 = i11 - i14;
            bArr[i15] = (byte) (i16 >>> 8);
            bArr[i15 + 1] = (byte) i16;
            i12 = i13 + 1;
        }
    }
}
