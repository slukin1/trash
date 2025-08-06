package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class DemuxOutputStream extends OutputStream {

    /* renamed from: b  reason: collision with root package name */
    public final InheritableThreadLocal<OutputStream> f58963b = new InheritableThreadLocal<>();

    public void close() throws IOException {
        OutputStream outputStream = (OutputStream) this.f58963b.get();
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = (OutputStream) this.f58963b.get();
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public void write(int i11) throws IOException {
        OutputStream outputStream = (OutputStream) this.f58963b.get();
        if (outputStream != null) {
            outputStream.write(i11);
        }
    }
}
