package com.huobi.woodpecker.kalle;

import com.huobi.woodpecker.kalle.BasicOutData;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicLong;

public abstract class BasicOutData<T extends BasicOutData<T>> implements h {

    /* renamed from: a  reason: collision with root package name */
    public j<T> f21013a;

    public static class b extends OutputStream {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicLong f21014b = new AtomicLong(0);

        public long a() {
            return this.f21014b.get();
        }

        public void b(long j11) throws IOException {
            this.f21014b.addAndGet(j11);
        }

        public void close() throws IOException {
        }

        public void flush() throws IOException {
        }

        public void write(int i11) throws IOException {
            this.f21014b.addAndGet(1);
        }

        public void write(byte[] bArr) throws IOException {
            this.f21014b.addAndGet((long) bArr.length);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            this.f21014b.addAndGet((long) i12);
        }
    }

    public static class c<T extends BasicOutData<T>> extends OutputStream {

        /* renamed from: b  reason: collision with root package name */
        public OutputStream f21015b;

        /* renamed from: c  reason: collision with root package name */
        public T f21016c;

        /* renamed from: d  reason: collision with root package name */
        public j<T> f21017d;

        /* renamed from: e  reason: collision with root package name */
        public long f21018e;

        /* renamed from: f  reason: collision with root package name */
        public long f21019f;

        /* renamed from: g  reason: collision with root package name */
        public int f21020g;

        public final void a() {
            int i11;
            long j11 = this.f21018e;
            if (j11 > 0 && (i11 = (int) ((this.f21019f * 100) / j11)) > this.f21020g && i11 % 2 == 0) {
                this.f21020g = i11;
                this.f21017d.a(this.f21016c, i11);
            }
        }

        public void close() throws IOException {
            this.f21015b.close();
        }

        public void flush() throws IOException {
            this.f21015b.flush();
        }

        public void write(int i11) throws IOException {
            this.f21015b.write(i11);
            this.f21019f++;
            a();
        }

        public c(OutputStream outputStream, T t11, j<T> jVar) {
            this.f21015b = outputStream;
            this.f21016c = t11;
            this.f21017d = jVar;
            this.f21018e = t11.length();
        }

        public void write(byte[] bArr) throws IOException {
            this.f21015b.write(bArr);
            this.f21019f += (long) bArr.length;
            a();
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            this.f21015b.write(bArr, i11, i12);
            this.f21019f += (long) i12;
            a();
        }
    }

    public abstract void a(OutputStream outputStream) throws IOException;

    public final void writeTo(OutputStream outputStream) throws IOException {
        if (this.f21013a != null) {
            a(new c(outputStream, this, this.f21013a));
        } else {
            a(outputStream);
        }
    }
}
