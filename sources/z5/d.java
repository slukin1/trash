package z5;

import java.io.IOException;
import java.io.InputStream;
import y5.a;

public class d implements a {

    /* renamed from: b  reason: collision with root package name */
    public a f66733b;

    public d(a aVar) {
        this.f66733b = aVar;
    }

    public InputStream a() throws IOException {
        reset();
        return this.f66733b.a();
    }

    public int available() throws IOException {
        return this.f66733b.available();
    }

    public int b() {
        return this.f66733b.b();
    }

    public void close() throws IOException {
        this.f66733b.close();
    }

    public byte peek() throws IOException {
        return this.f66733b.peek();
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.f66733b.read(bArr, i11, i12);
    }

    public void reset() throws IOException {
        this.f66733b.reset();
    }

    public long skip(long j11) throws IOException {
        return this.f66733b.skip(j11);
    }
}
