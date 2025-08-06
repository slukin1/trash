package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@GwtIncompatible
final class MultiInputStream extends InputStream {

    /* renamed from: in  reason: collision with root package name */
    private InputStream f66951in;

    /* renamed from: it  reason: collision with root package name */
    private Iterator<? extends ByteSource> f66952it;

    public MultiInputStream(Iterator<? extends ByteSource> it2) throws IOException {
        this.f66952it = (Iterator) Preconditions.checkNotNull(it2);
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.f66952it.hasNext()) {
            this.f66951in = ((ByteSource) this.f66952it.next()).openStream();
        }
    }

    public int available() throws IOException {
        InputStream inputStream = this.f66951in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    public void close() throws IOException {
        InputStream inputStream = this.f66951in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f66951in = null;
            }
        }
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f66951in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    public long skip(long j11) throws IOException {
        InputStream inputStream = this.f66951in;
        if (inputStream == null || j11 <= 0) {
            return 0;
        }
        long skip = inputStream.skip(j11);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0;
        }
        return this.f66951in.skip(j11 - 1) + 1;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        while (true) {
            InputStream inputStream = this.f66951in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i11, i12);
            if (read != -1) {
                return read;
            }
            advance();
        }
    }
}
