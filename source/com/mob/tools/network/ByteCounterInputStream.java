package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.IOException;
import java.io.InputStream;

public class ByteCounterInputStream extends InputStream implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f27907a;

    /* renamed from: b  reason: collision with root package name */
    private long f27908b;

    /* renamed from: c  reason: collision with root package name */
    private OnReadListener f27909c;

    public ByteCounterInputStream(InputStream inputStream) {
        this.f27907a = inputStream;
    }

    public int available() throws IOException {
        return this.f27907a.available();
    }

    public void close() throws IOException {
        this.f27907a.close();
    }

    public void mark(int i11) {
        this.f27907a.mark(i11);
    }

    public boolean markSupported() {
        return this.f27907a.markSupported();
    }

    public int read() throws IOException {
        int read = this.f27907a.read();
        if (read >= 0) {
            long j11 = this.f27908b + 1;
            this.f27908b = j11;
            OnReadListener onReadListener = this.f27909c;
            if (onReadListener != null) {
                onReadListener.onRead(j11);
            }
        }
        return read;
    }

    public synchronized void reset() throws IOException {
        this.f27907a.reset();
        this.f27908b = 0;
    }

    public void setOnInputStreamReadListener(OnReadListener onReadListener) {
        this.f27909c = onReadListener;
    }

    public long skip(long j11) throws IOException {
        return this.f27907a.skip(j11);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = this.f27907a.read(bArr, i11, i12);
        if (read > 0) {
            long j11 = this.f27908b + ((long) read);
            this.f27908b = j11;
            OnReadListener onReadListener = this.f27909c;
            if (onReadListener != null) {
                onReadListener.onRead(j11);
            }
        }
        return read;
    }
}
