package z5;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import y5.a;

public class e extends FilterInputStream implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f66734b;

    public e(InputStream inputStream) {
        super(inputStream);
        try {
            inputStream.reset();
        } catch (IOException unused) {
        }
    }

    public InputStream a() throws IOException {
        return this;
    }

    public int b() {
        return this.f66734b;
    }

    public byte peek() throws IOException {
        byte read = (byte) read();
        this.f66734b++;
        return read;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = super.read(bArr, i11, i12);
        this.f66734b += Math.max(0, read);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.f66734b = 0;
    }

    public long skip(long j11) throws IOException {
        long skip = super.skip(j11);
        this.f66734b = (int) (((long) this.f66734b) + skip);
        return skip;
    }
}
