package com.bumptech.glide.load.engine.bitmap_recycle;

public final class ByteArrayAdapter implements a<byte[]> {
    public int b() {
        return 1;
    }

    /* renamed from: c */
    public int a(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: d */
    public byte[] newArray(int i11) {
        return new byte[i11];
    }

    public String getTag() {
        return "ByteArrayPool";
    }
}
