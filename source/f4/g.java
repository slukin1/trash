package f4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class g extends FilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    public int f66260b = Integer.MIN_VALUE;

    public g(InputStream inputStream) {
        super(inputStream);
    }

    public final long a(long j11) {
        int i11 = this.f66260b;
        if (i11 == 0) {
            return -1;
        }
        return (i11 == Integer.MIN_VALUE || j11 <= ((long) i11)) ? j11 : (long) i11;
    }

    public int available() throws IOException {
        int i11 = this.f66260b;
        if (i11 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i11, super.available());
    }

    public final void b(long j11) {
        int i11 = this.f66260b;
        if (i11 != Integer.MIN_VALUE && j11 != -1) {
            this.f66260b = (int) (((long) i11) - j11);
        }
    }

    public synchronized void mark(int i11) {
        super.mark(i11);
        this.f66260b = i11;
    }

    public int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        b(1);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.f66260b = Integer.MIN_VALUE;
    }

    public long skip(long j11) throws IOException {
        long a11 = a(j11);
        if (a11 == -1) {
            return 0;
        }
        long skip = super.skip(a11);
        b(skip);
        return skip;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int a11 = (int) a((long) i12);
        if (a11 == -1) {
            return -1;
        }
        int read = super.read(bArr, i11, a11);
        b((long) read);
        return read;
    }
}
