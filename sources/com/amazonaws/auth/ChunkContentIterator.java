package com.amazonaws.auth;

class ChunkContentIterator {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f14841a;

    /* renamed from: b  reason: collision with root package name */
    public int f14842b;

    public ChunkContentIterator(byte[] bArr) {
        this.f14841a = bArr;
    }

    public boolean a() {
        return this.f14842b < this.f14841a.length;
    }

    public int b(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        if (!a()) {
            return -1;
        }
        int min = Math.min(this.f14841a.length - this.f14842b, i12);
        System.arraycopy(this.f14841a, this.f14842b, bArr, i11, min);
        this.f14842b += min;
        return min;
    }
}
