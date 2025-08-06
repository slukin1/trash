package ox;

import java.io.IOException;
import java.io.InputStream;

public class a extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    public final InputStream f29161b;

    /* renamed from: c  reason: collision with root package name */
    public final int f29162c;

    public a(InputStream inputStream, int i11) {
        this.f29161b = inputStream;
        this.f29162c = i11;
    }

    public int available() {
        return this.f29162c;
    }

    public void close() throws IOException {
        this.f29161b.close();
    }

    public void mark(int i11) {
        this.f29161b.mark(i11);
    }

    public boolean markSupported() {
        return this.f29161b.markSupported();
    }

    public int read() throws IOException {
        return this.f29161b.read();
    }

    public void reset() throws IOException {
        this.f29161b.reset();
    }

    public long skip(long j11) throws IOException {
        return this.f29161b.skip(j11);
    }

    public int read(byte[] bArr) throws IOException {
        return this.f29161b.read(bArr);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.f29161b.read(bArr, i11, i12);
    }
}
