package com.xiaomi.push;

import java.io.IOException;

public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public abstract void a(c cVar);

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m2631a() {
        int b11 = b();
        byte[] bArr = new byte[b11];
        a(bArr, 0, b11);
        return bArr;
    }

    public abstract int b();

    /* renamed from: a  reason: collision with other method in class */
    public void m2630a(byte[] bArr, int i11, int i12) {
        try {
            c a11 = c.a(bArr, i11, i12);
            a(a11);
            a11.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public e a(byte[] bArr, int i11, int i12) {
        try {
            b a11 = b.a(bArr, i11, i12);
            a(a11);
            a11.a(0);
            return this;
        } catch (d e11) {
            throw e11;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public boolean a(b bVar, int i11) {
        return bVar.a(i11);
    }
}
