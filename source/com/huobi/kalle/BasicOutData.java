package com.huobi.kalle;

import com.huobi.kalle.BasicOutData;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicLong;

public abstract class BasicOutData<T extends BasicOutData<T>> implements h {

    /* renamed from: a  reason: collision with root package name */
    public j<T> f74655a;

    public static class b extends OutputStream {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicLong f74656b = new AtomicLong(0);

        public long a() {
            return this.f74656b.get();
        }

        public void b(long j11) throws IOException {
            this.f74656b.addAndGet(j11);
        }

        public void close() throws IOException {
        }

        public void flush() throws IOException {
        }

        public void write(int i11) throws IOException {
            this.f74656b.addAndGet(1);
        }

        public void write(byte[] bArr) throws IOException {
            this.f74656b.addAndGet((long) bArr.length);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            this.f74656b.addAndGet((long) i12);
        }
    }

    public static class c<T extends BasicOutData<T>> extends OutputStream {

        /* renamed from: b  reason: collision with root package name */
        public OutputStream f74657b;

        /* renamed from: c  reason: collision with root package name */
        public T f74658c;

        /* renamed from: d  reason: collision with root package name */
        public j<T> f74659d;

        /* renamed from: e  reason: collision with root package name */
        public long f74660e;

        /* renamed from: f  reason: collision with root package name */
        public long f74661f;

        /* renamed from: g  reason: collision with root package name */
        public int f74662g;

        public final void a() {
            int i11;
            long j11 = this.f74660e;
            if (j11 > 0 && (i11 = (int) ((this.f74661f * 100) / j11)) > this.f74662g && i11 % 2 == 0) {
                this.f74662g = i11;
                this.f74659d.a(this.f74658c, i11);
            }
        }

        public void close() throws IOException {
            this.f74657b.close();
        }

        public void flush() throws IOException {
            this.f74657b.flush();
        }

        public void write(int i11) throws IOException {
            this.f74657b.write(i11);
            this.f74661f++;
            a();
        }

        public c(OutputStream outputStream, T t11, j<T> jVar) {
            this.f74657b = outputStream;
            this.f74658c = t11;
            this.f74659d = jVar;
            this.f74660e = t11.length();
        }

        public void write(byte[] bArr) throws IOException {
            this.f74657b.write(bArr);
            this.f74661f += (long) bArr.length;
            a();
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            this.f74657b.write(bArr, i11, i12);
            this.f74661f += (long) i12;
            a();
        }
    }

    public abstract void a(OutputStream outputStream) throws IOException;

    public final void writeTo(OutputStream outputStream) throws IOException {
        if (this.f74655a != null) {
            a(new c(outputStream, this, this.f74655a));
        } else {
            a(outputStream);
        }
    }
}
