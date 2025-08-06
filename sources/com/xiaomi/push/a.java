package com.xiaomi.push;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f51353a = new a(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    private volatile int f2495a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f2496a;

    private a(byte[] bArr) {
        this.f2496a = bArr;
    }

    public int a() {
        return this.f2496a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f2496a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f2496a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i11 = this.f2495a;
        if (i11 == 0) {
            int i12 = r1;
            for (byte b11 : this.f2496a) {
                i12 = (i12 * 31) + b11;
            }
            i11 = i12 == 0 ? 1 : i12;
            this.f2495a = i11;
        }
        return i11;
    }

    public static a a(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        return new a(bArr2);
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m2383a() {
        byte[] bArr = this.f2496a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
