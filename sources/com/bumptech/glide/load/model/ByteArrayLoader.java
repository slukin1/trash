package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import o3.d;
import s3.d;

public class ByteArrayLoader<Data> implements d<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Data> f63944a;

    public static class ByteBufferFactory implements d<byte[], ByteBuffer> {

        public class a implements a<ByteBuffer> {
            public a() {
            }

            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            /* renamed from: c */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        public d<byte[], ByteBuffer> b(f fVar) {
            return new ByteArrayLoader(new a());
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements d<byte[], InputStream> {

        public class a implements a<InputStream> {
            public a() {
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        public d<byte[], InputStream> b(f fVar) {
            return new ByteArrayLoader(new a());
        }

        public void teardown() {
        }
    }

    public interface a<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    public static class b<Data> implements o3.d<Data> {

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f63947b;

        /* renamed from: c  reason: collision with root package name */
        public final a<Data> f63948c;

        public b(byte[] bArr, a<Data> aVar) {
            this.f63947b = bArr;
            this.f63948c = aVar;
        }

        public Class<Data> a() {
            return this.f63948c.a();
        }

        public void b() {
        }

        public DataSource c() {
            return DataSource.LOCAL;
        }

        public void cancel() {
        }

        public void f(Priority priority, d.a<? super Data> aVar) {
            aVar.d(this.f63948c.b(this.f63947b));
        }
    }

    public ByteArrayLoader(a<Data> aVar) {
        this.f63944a = aVar;
    }

    /* renamed from: c */
    public d.a<Data> a(byte[] bArr, int i11, int i12, Options options) {
        return new d.a<>(new e4.d(bArr), new b(bArr, this.f63944a));
    }

    /* renamed from: d */
    public boolean b(byte[] bArr) {
        return true;
    }
}
