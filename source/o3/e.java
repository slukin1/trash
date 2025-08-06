package o3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e extends FilterInputStream {

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f66520d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f66521e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f66522f;

    /* renamed from: b  reason: collision with root package name */
    public final byte f66523b;

    /* renamed from: c  reason: collision with root package name */
    public int f66524c;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, Framer.EXIT_FRAME_PREFIX, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f66520d = bArr;
        int length = bArr.length;
        f66521e = length;
        f66522f = length + 2;
    }

    public e(InputStream inputStream, int i11) {
        super(inputStream);
        if (i11 < -1 || i11 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i11);
        }
        this.f66523b = (byte) i11;
    }

    public void mark(int i11) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int i11;
        int i12;
        int i13 = this.f66524c;
        if (i13 < 2 || i13 > (i12 = f66522f)) {
            i11 = super.read();
        } else if (i13 == i12) {
            i11 = this.f66523b;
        } else {
            i11 = f66520d[i13 - 2] & 255;
        }
        if (i11 != -1) {
            this.f66524c++;
        }
        return i11;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j11) throws IOException {
        long skip = super.skip(j11);
        if (skip > 0) {
            this.f66524c = (int) (((long) this.f66524c) + skip);
        }
        return skip;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        int i14 = this.f66524c;
        int i15 = f66522f;
        if (i14 > i15) {
            i13 = super.read(bArr, i11, i12);
        } else if (i14 == i15) {
            bArr[i11] = this.f66523b;
            i13 = 1;
        } else if (i14 < 2) {
            i13 = super.read(bArr, i11, 2 - i14);
        } else {
            int min = Math.min(i15 - i14, i12);
            System.arraycopy(f66520d, this.f66524c - 2, bArr, i11, min);
            i13 = min;
        }
        if (i13 > 0) {
            this.f66524c += i13;
        }
        return i13;
    }
}
