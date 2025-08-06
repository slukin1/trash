package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class BrokenInputStream extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    public final IOException f58947b;

    public BrokenInputStream(IOException iOException) {
        this.f58947b = iOException;
    }

    public int available() throws IOException {
        throw this.f58947b;
    }

    public void close() throws IOException {
        throw this.f58947b;
    }

    public int read() throws IOException {
        throw this.f58947b;
    }

    public synchronized void reset() throws IOException {
        throw this.f58947b;
    }

    public long skip(long j11) throws IOException {
        throw this.f58947b;
    }

    public BrokenInputStream() {
        this(new IOException("Broken input stream"));
    }
}
