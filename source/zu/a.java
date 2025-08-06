package zu;

import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.InputStream;
import xu.c;

public class a extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    public final c f23465b;

    public a(c cVar) {
        this.f23465b = cVar;
    }

    public int available() {
        return 0;
    }

    public void close() {
        IOUtils.a(this.f23465b);
    }

    public void mark(int i11) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        return 0;
    }

    public int read(byte[] bArr) {
        return 0;
    }

    public int read(byte[] bArr, int i11, int i12) {
        return 0;
    }

    public void reset() {
    }

    public long skip(long j11) {
        return 0;
    }
}
