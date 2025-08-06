package m10;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import n10.b;

public class a extends b {

    /* renamed from: l  reason: collision with root package name */
    public Inflater f58097l = new Inflater(true);

    /* renamed from: m  reason: collision with root package name */
    public byte[] f58098m = new byte[4096];

    /* renamed from: n  reason: collision with root package name */
    public byte[] f58099n = new byte[1];

    /* renamed from: o  reason: collision with root package name */
    public b f58100o;

    /* renamed from: p  reason: collision with root package name */
    public long f58101p;

    /* renamed from: q  reason: collision with root package name */
    public long f58102q;

    public a(RandomAccessFile randomAccessFile, long j11, long j12, b bVar) {
        super(randomAccessFile, j11, j12, bVar);
        this.f58100o = bVar;
        this.f58101p = 0;
        this.f58102q = bVar.j().o();
    }

    public b a() {
        return super.a();
    }

    public int available() {
        return this.f58097l.finished() ^ true ? 1 : 0;
    }

    public void close() throws IOException {
        this.f58097l.end();
        super.close();
    }

    public final void e() throws IOException {
        byte[] bArr = this.f58098m;
        int read = super.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f58097l.setInput(this.f58098m, 0, read);
            return;
        }
        throw new EOFException("Unexpected end of ZLIB input stream");
    }

    public final void f() throws IOException {
        do {
        } while (super.read(new byte[1024], 0, 1024) != -1);
        b();
    }

    public int read() throws IOException {
        if (read(this.f58099n, 0, 1) == -1) {
            return -1;
        }
        return this.f58099n[0] & 255;
    }

    public long skip(long j11) throws IOException {
        if (j11 >= 0) {
            int min = (int) Math.min(j11, 2147483647L);
            byte[] bArr = new byte[512];
            int i11 = 0;
            while (i11 < min) {
                int i12 = min - i11;
                if (i12 > 512) {
                    i12 = 512;
                }
                int read = read(bArr, 0, i12);
                if (read == -1) {
                    break;
                }
                i11 += read;
            }
            return (long) i11;
        }
        throw new IllegalArgumentException("negative skip length");
    }

    public int read(byte[] bArr) throws IOException {
        Objects.requireNonNull(bArr, "input buffer is null");
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        Objects.requireNonNull(bArr, "input buffer is null");
        if (i11 < 0 || i12 < 0 || i12 > bArr.length - i11) {
            throw new IndexOutOfBoundsException();
        } else if (i12 == 0) {
            return 0;
        } else {
            try {
                if (this.f58101p >= this.f58102q) {
                    f();
                    return -1;
                }
                while (true) {
                    int inflate = this.f58097l.inflate(bArr, i11, i12);
                    if (inflate != 0) {
                        this.f58101p += (long) inflate;
                        return inflate;
                    } else if (this.f58097l.finished()) {
                        break;
                    } else if (this.f58097l.needsDictionary()) {
                        break;
                    } else if (this.f58097l.needsInput()) {
                        e();
                    }
                }
                f();
                return -1;
            } catch (DataFormatException e11) {
                String message = e11.getMessage() != null ? e11.getMessage() : "Invalid ZLIB data format";
                b bVar = this.f58100o;
                if (bVar != null && bVar.l().l() && this.f58100o.l().e() == 0) {
                    message = message + " - Wrong Password?";
                }
                throw new IOException(message);
            }
        }
    }
}
