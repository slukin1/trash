package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SdkFilterInputStream extends FilterInputStream implements MetricAware {
    public SdkFilterInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Deprecated
    public boolean a() {
        if (this.in instanceof MetricAware) {
            return ((MetricAware) this.in).a();
        }
        return false;
    }

    public int available() throws IOException {
        e();
        return this.in.available();
    }

    public void b() {
    }

    public void close() throws IOException {
        this.in.close();
        e();
    }

    public final void e() {
        if (Thread.interrupted()) {
            b();
            throw new AbortedException();
        }
    }

    public synchronized void mark(int i11) {
        e();
        this.in.mark(i11);
    }

    public boolean markSupported() {
        e();
        return this.in.markSupported();
    }

    public int read() throws IOException {
        e();
        return this.in.read();
    }

    public synchronized void reset() throws IOException {
        e();
        this.in.reset();
    }

    public long skip(long j11) throws IOException {
        e();
        return this.in.skip(j11);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        e();
        return this.in.read(bArr, i11, i12);
    }
}
