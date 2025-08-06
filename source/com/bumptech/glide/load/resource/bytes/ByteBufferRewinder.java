package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.a;
import java.nio.ByteBuffer;

public class ByteBufferRewinder implements a<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f64135a;

    public static class Factory implements a.C0699a<ByteBuffer> {
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        /* renamed from: c */
        public a<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f64135a = byteBuffer;
    }

    /* renamed from: a */
    public ByteBuffer c() {
        this.f64135a.position(0);
        return this.f64135a;
    }

    public void b() {
    }
}
