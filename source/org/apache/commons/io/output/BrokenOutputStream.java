package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class BrokenOutputStream extends OutputStream {

    /* renamed from: b  reason: collision with root package name */
    public final IOException f58954b;

    public BrokenOutputStream(IOException iOException) {
        this.f58954b = iOException;
    }

    public void close() throws IOException {
        throw this.f58954b;
    }

    public void flush() throws IOException {
        throw this.f58954b;
    }

    public void write(int i11) throws IOException {
        throw this.f58954b;
    }

    public BrokenOutputStream() {
        this(new IOException("Broken output stream"));
    }
}
