package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class DemuxInputStream extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    public final InheritableThreadLocal<InputStream> f58949b = new InheritableThreadLocal<>();

    public void close() throws IOException {
        InputStream inputStream = (InputStream) this.f58949b.get();
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public int read() throws IOException {
        InputStream inputStream = (InputStream) this.f58949b.get();
        if (inputStream != null) {
            return inputStream.read();
        }
        return -1;
    }
}
