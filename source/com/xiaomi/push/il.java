package com.xiaomi.push;

public abstract class il {
    public abstract int a(byte[] bArr, int i11, int i12);

    public void a(int i11) {
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract void m2904a(byte[] bArr, int i11, int i12);

    public byte[] a() {
        return null;
    }

    public int a_() {
        return 0;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i12) {
            int a11 = a(bArr, i11 + i13, i12 - i13);
            if (a11 > 0) {
                i13 += a11;
            } else {
                throw new im("Cannot read. Remote side has closed. Tried to read " + i12 + " bytes, but only got " + i13 + " bytes.");
            }
        }
        return i13;
    }
}
