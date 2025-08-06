package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class m extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    public final InputStream f30062b;

    /* renamed from: c  reason: collision with root package name */
    public long f30063c;

    /* renamed from: d  reason: collision with root package name */
    public long f30064d;

    /* renamed from: e  reason: collision with root package name */
    public long f30065e;

    /* renamed from: f  reason: collision with root package name */
    public long f30066f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30067g;

    /* renamed from: h  reason: collision with root package name */
    public int f30068h;

    public m(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public void a(boolean z11) {
        this.f30067g = z11;
    }

    public int available() throws IOException {
        return this.f30062b.available();
    }

    public void b(long j11) throws IOException {
        if (this.f30063c > this.f30065e || j11 < this.f30064d) {
            throw new IOException("Cannot reset");
        }
        this.f30062b.reset();
        g(this.f30064d, j11);
        this.f30063c = j11;
    }

    public void close() throws IOException {
        this.f30062b.close();
    }

    public long e(int i11) {
        long j11 = this.f30063c + ((long) i11);
        if (this.f30065e < j11) {
            f(j11);
        }
        return this.f30063c;
    }

    public final void f(long j11) {
        try {
            long j12 = this.f30064d;
            long j13 = this.f30063c;
            if (j12 >= j13 || j13 > this.f30065e) {
                this.f30064d = j13;
                this.f30062b.mark((int) (j11 - j13));
            } else {
                this.f30062b.reset();
                this.f30062b.mark((int) (j11 - this.f30064d));
                g(this.f30064d, this.f30063c);
            }
            this.f30065e = j11;
        } catch (IOException e11) {
            throw new IllegalStateException("Unable to mark: " + e11);
        }
    }

    public final void g(long j11, long j12) throws IOException {
        while (j11 < j12) {
            long skip = this.f30062b.skip(j12 - j11);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j11 += skip;
        }
    }

    public void mark(int i11) {
        this.f30066f = e(i11);
    }

    public boolean markSupported() {
        return this.f30062b.markSupported();
    }

    public int read() throws IOException {
        if (!this.f30067g) {
            long j11 = this.f30065e;
            if (this.f30063c + 1 > j11) {
                f(j11 + ((long) this.f30068h));
            }
        }
        int read = this.f30062b.read();
        if (read != -1) {
            this.f30063c++;
        }
        return read;
    }

    public void reset() throws IOException {
        b(this.f30066f);
    }

    public long skip(long j11) throws IOException {
        if (!this.f30067g) {
            long j12 = this.f30063c;
            if (j12 + j11 > this.f30065e) {
                f(j12 + j11 + ((long) this.f30068h));
            }
        }
        long skip = this.f30062b.skip(j11);
        this.f30063c += skip;
        return skip;
    }

    public m(InputStream inputStream, int i11) {
        this(inputStream, i11, 1024);
    }

    public m(InputStream inputStream, int i11, int i12) {
        this.f30066f = -1;
        this.f30067g = true;
        this.f30068h = -1;
        this.f30062b = !inputStream.markSupported() ? new BufferedInputStream(inputStream, i11) : inputStream;
        this.f30068h = i12;
    }

    public int read(byte[] bArr) throws IOException {
        if (!this.f30067g) {
            long j11 = this.f30063c;
            if (((long) bArr.length) + j11 > this.f30065e) {
                f(j11 + ((long) bArr.length) + ((long) this.f30068h));
            }
        }
        int read = this.f30062b.read(bArr);
        if (read != -1) {
            this.f30063c += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (!this.f30067g) {
            long j11 = this.f30063c;
            long j12 = (long) i12;
            if (j11 + j12 > this.f30065e) {
                f(j11 + j12 + ((long) this.f30068h));
            }
        }
        int read = this.f30062b.read(bArr, i11, i12);
        if (read != -1) {
            this.f30063c += (long) read;
        }
        return read;
    }
}
