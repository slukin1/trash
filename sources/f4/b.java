package f4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b extends FilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    public final long f66247b;

    /* renamed from: c  reason: collision with root package name */
    public int f66248c;

    public b(InputStream inputStream, long j11) {
        super(inputStream);
        this.f66247b = j11;
    }

    public static InputStream b(InputStream inputStream, long j11) {
        return new b(inputStream, j11);
    }

    public final int a(int i11) throws IOException {
        if (i11 >= 0) {
            this.f66248c += i11;
        } else if (this.f66247b - ((long) this.f66248c) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f66247b + ", but read: " + this.f66248c);
        }
        return i11;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f66247b - ((long) this.f66248c), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i11, int i12) throws IOException {
        return a(super.read(bArr, i11, i12));
    }
}
