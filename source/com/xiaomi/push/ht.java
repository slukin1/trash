package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

public class ht extends ByteArrayOutputStream {
    public ht(int i11) {
        super(i11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m2862a() {
        return this.buf;
    }

    public ht() {
    }

    public int a() {
        return this.count;
    }
}
