package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputSubstream extends SdkFilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    public long f15147b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final long f15148c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15149d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15150e;

    /* renamed from: f  reason: collision with root package name */
    public long f15151f = 0;

    public InputSubstream(InputStream inputStream, long j11, long j12, boolean z11) {
        super(inputStream);
        this.f15149d = j12;
        this.f15148c = j11;
        this.f15150e = z11;
    }

    public int available() throws IOException {
        long j11;
        long j12 = this.f15147b;
        long j13 = this.f15148c;
        if (j12 < j13) {
            j11 = this.f15149d;
        } else {
            j11 = (this.f15149d + j13) - j12;
        }
        return (int) Math.min(j11, (long) super.available());
    }

    public void close() throws IOException {
        if (this.f15150e) {
            super.close();
        }
    }

    public synchronized void mark(int i11) {
        this.f15151f = this.f15147b;
        super.mark(i11);
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read == -1) {
            return read;
        }
        return bArr[0];
    }

    public synchronized void reset() throws IOException {
        this.f15147b = this.f15151f;
        super.reset();
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        long j11;
        long j12;
        while (true) {
            j11 = this.f15147b;
            j12 = this.f15148c;
            if (j11 >= j12) {
                break;
            }
            this.f15147b += super.skip(j12 - j11);
        }
        long j13 = (this.f15149d + j12) - j11;
        if (j13 <= 0) {
            return -1;
        }
        int read = super.read(bArr, i11, (int) Math.min((long) i12, j13));
        this.f15147b += (long) read;
        return read;
    }
}
