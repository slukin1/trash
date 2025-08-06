package zu;

import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import xu.c;

public class b extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    public final c f23466b;

    /* renamed from: c  reason: collision with root package name */
    public final InputStream f23467c;

    public b(c cVar, InputStream inputStream) {
        this.f23466b = cVar;
        this.f23467c = inputStream;
    }

    public int available() throws IOException {
        return this.f23467c.available();
    }

    public void close() throws IOException {
        IOUtils.a(this.f23467c);
        IOUtils.a(this.f23466b);
    }

    public synchronized void mark(int i11) {
        this.f23467c.mark(i11);
    }

    public boolean markSupported() {
        return this.f23467c.markSupported();
    }

    public int read() throws IOException {
        return this.f23467c.read();
    }

    public void reset() throws IOException {
        this.f23467c.reset();
    }

    public long skip(long j11) throws IOException {
        return this.f23467c.skip(j11);
    }

    public int read(byte[] bArr) throws IOException {
        return this.f23467c.read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.f23467c.read(bArr, i11, i12);
    }
}
