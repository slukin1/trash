package jm;

import com.huobi.kalle.util.IOUtils;
import hm.c;
import java.io.IOException;
import java.io.InputStream;

public class b extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    public final c f76229b;

    /* renamed from: c  reason: collision with root package name */
    public final InputStream f76230c;

    public b(c cVar, InputStream inputStream) {
        this.f76229b = cVar;
        this.f76230c = inputStream;
    }

    public int available() throws IOException {
        return this.f76230c.available();
    }

    public void close() throws IOException {
        IOUtils.a(this.f76230c);
        IOUtils.a(this.f76229b);
    }

    public synchronized void mark(int i11) {
        this.f76230c.mark(i11);
    }

    public boolean markSupported() {
        return this.f76230c.markSupported();
    }

    public int read() throws IOException {
        return this.f76230c.read();
    }

    public void reset() throws IOException {
        this.f76230c.reset();
    }

    public long skip(long j11) throws IOException {
        return this.f76230c.skip(j11);
    }

    public int read(byte[] bArr) throws IOException {
        return this.f76230c.read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.f76230c.read(bArr, i11, i12);
    }
}
