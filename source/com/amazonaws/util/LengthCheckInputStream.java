package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LengthCheckInputStream extends SdkFilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    public final long f15552b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f15553c;

    /* renamed from: d  reason: collision with root package name */
    public long f15554d;

    /* renamed from: e  reason: collision with root package name */
    public long f15555e;

    public LengthCheckInputStream(InputStream inputStream, long j11, boolean z11) {
        super(inputStream);
        if (j11 >= 0) {
            this.f15552b = j11;
            this.f15553c = z11;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final void f(boolean z11) {
        if (z11) {
            if (this.f15554d != this.f15552b) {
                throw new AmazonClientException("Data read (" + this.f15554d + ") has a different length than the expected (" + this.f15552b + ")");
            }
        } else if (this.f15554d > this.f15552b) {
            throw new AmazonClientException("More data read (" + this.f15554d + ") than expected (" + this.f15552b + ")");
        }
    }

    public void mark(int i11) {
        super.mark(i11);
        this.f15555e = this.f15554d;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read >= 0) {
            this.f15554d++;
        }
        f(read == -1);
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        if (super.markSupported()) {
            this.f15554d = this.f15555e;
        }
    }

    public long skip(long j11) throws IOException {
        long skip = super.skip(j11);
        if (this.f15553c && skip > 0) {
            this.f15554d += skip;
            f(false);
        }
        return skip;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = super.read(bArr, i11, i12);
        this.f15554d += read >= 0 ? (long) read : 0;
        f(read == -1);
        return read;
    }
}
