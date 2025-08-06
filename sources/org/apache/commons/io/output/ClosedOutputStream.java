package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class ClosedOutputStream extends OutputStream {

    /* renamed from: b  reason: collision with root package name */
    public static final ClosedOutputStream f58962b = new ClosedOutputStream();

    public void flush() throws IOException {
        throw new IOException("flush() failed: stream is closed");
    }

    public void write(int i11) throws IOException {
        throw new IOException("write(" + i11 + ") failed: stream is closed");
    }
}
