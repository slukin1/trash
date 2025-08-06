package m10;

import j10.a;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.BaseInputStream;

public class b extends BaseInputStream {

    /* renamed from: b  reason: collision with root package name */
    public RandomAccessFile f58103b;

    /* renamed from: c  reason: collision with root package name */
    public long f58104c;

    /* renamed from: d  reason: collision with root package name */
    public long f58105d;

    /* renamed from: e  reason: collision with root package name */
    public n10.b f58106e;

    /* renamed from: f  reason: collision with root package name */
    public j10.b f58107f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f58108g = new byte[1];

    /* renamed from: h  reason: collision with root package name */
    public byte[] f58109h = new byte[16];

    /* renamed from: i  reason: collision with root package name */
    public int f58110i = 0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f58111j = false;

    /* renamed from: k  reason: collision with root package name */
    public int f58112k = -1;

    public b(RandomAccessFile randomAccessFile, long j11, long j12, n10.b bVar) {
        boolean z11 = true;
        this.f58103b = randomAccessFile;
        this.f58106e = bVar;
        this.f58107f = bVar.i();
        this.f58104c = 0;
        this.f58105d = j12;
        this.f58111j = (!bVar.j().r() || bVar.j().g() != 99) ? false : z11;
    }

    public n10.b a() {
        return this.f58106e;
    }

    public int available() {
        long j11 = this.f58105d - this.f58104c;
        if (j11 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j11;
    }

    public void b() throws IOException {
        j10.b bVar;
        if (this.f58111j && (bVar = this.f58107f) != null && (bVar instanceof a) && ((a) bVar).f() == null) {
            byte[] bArr = new byte[10];
            int read = this.f58103b.read(bArr);
            if (read != 10) {
                if (this.f58106e.p().h()) {
                    this.f58103b.close();
                    RandomAccessFile s11 = this.f58106e.s();
                    this.f58103b = s11;
                    s11.read(bArr, read, 10 - read);
                } else {
                    throw new IOException("Error occured while reading stored AES authentication bytes");
                }
            }
            ((a) this.f58106e.i()).h(bArr);
        }
    }

    public void close() throws IOException {
        this.f58103b.close();
    }

    public int read() throws IOException {
        if (this.f58104c >= this.f58105d) {
            return -1;
        }
        if (this.f58111j) {
            int i11 = this.f58110i;
            if (i11 == 0 || i11 == 16) {
                if (read(this.f58109h) == -1) {
                    return -1;
                }
                this.f58110i = 0;
            }
            byte[] bArr = this.f58109h;
            int i12 = this.f58110i;
            this.f58110i = i12 + 1;
            return bArr[i12] & 255;
        } else if (read(this.f58108g, 0, 1) == -1) {
            return -1;
        } else {
            return this.f58108g[0] & 255;
        }
    }

    public long skip(long j11) throws IOException {
        if (j11 >= 0) {
            long j12 = this.f58105d;
            long j13 = this.f58104c;
            if (j11 > j12 - j13) {
                j11 = j12 - j13;
            }
            this.f58104c = j13 + j11;
            return j11;
        }
        throw new IllegalArgumentException();
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        long j11 = this.f58105d;
        long j12 = this.f58104c;
        if (((long) i12) <= j11 - j12 || (i12 = (int) (j11 - j12)) != 0) {
            if ((this.f58106e.i() instanceof a) && this.f58104c + ((long) i12) < this.f58105d && (i13 = i12 % 16) != 0) {
                i12 -= i13;
            }
            synchronized (this.f58103b) {
                int read = this.f58103b.read(bArr, i11, i12);
                this.f58112k = read;
                if (read < i12 && this.f58106e.p().h()) {
                    this.f58103b.close();
                    RandomAccessFile s11 = this.f58106e.s();
                    this.f58103b = s11;
                    if (this.f58112k < 0) {
                        this.f58112k = 0;
                    }
                    int i14 = this.f58112k;
                    int read2 = s11.read(bArr, i14, i12 - i14);
                    if (read2 > 0) {
                        this.f58112k += read2;
                    }
                }
            }
            int i15 = this.f58112k;
            if (i15 > 0) {
                j10.b bVar = this.f58107f;
                if (bVar != null) {
                    try {
                        bVar.a(bArr, i11, i15);
                    } catch (ZipException e11) {
                        throw new IOException(e11.getMessage());
                    }
                }
                this.f58104c += (long) this.f58112k;
            }
            if (this.f58104c >= this.f58105d) {
                b();
            }
            return this.f58112k;
        }
        b();
        return -1;
    }
}
