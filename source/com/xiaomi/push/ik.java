package com.xiaomi.push;

public final class ik extends il {

    /* renamed from: a  reason: collision with root package name */
    private int f52367a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f3251a;

    /* renamed from: b  reason: collision with root package name */
    private int f52368b;

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public int a_() {
        return this.f52367a;
    }

    public void b(byte[] bArr, int i11, int i12) {
        this.f3251a = bArr;
        this.f52367a = i11;
        this.f52368b = i11 + i12;
    }

    public int a(byte[] bArr, int i11, int i12) {
        int b11 = b();
        if (i12 > b11) {
            i12 = b11;
        }
        if (i12 > 0) {
            System.arraycopy(this.f3251a, this.f52367a, bArr, i11, i12);
            a(i12);
        }
        return i12;
    }

    public int b() {
        return this.f52368b - this.f52367a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2903a(byte[] bArr, int i11, int i12) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public byte[] a() {
        return this.f3251a;
    }

    public void a(int i11) {
        this.f52367a += i11;
    }
}
