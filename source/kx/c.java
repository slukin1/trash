package kx;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class c implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final InputStream f29133b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f29134c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f29135d;

    /* renamed from: e  reason: collision with root package name */
    public int f29136e;

    /* renamed from: f  reason: collision with root package name */
    public int f29137f;

    public class a extends ByteArrayOutputStream {
        public a(int i11) {
            super(i11);
        }

        public String toString() {
            int i11 = this.count;
            if (i11 > 0 && this.buf[i11 - 1] == 13) {
                i11--;
            }
            try {
                return new String(this.buf, 0, i11, c.this.f29134c.name());
            } catch (UnsupportedEncodingException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void b() throws IOException {
        InputStream inputStream = this.f29133b;
        byte[] bArr = this.f29135d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f29136e = 0;
            this.f29137f = read;
            return;
        }
        throw new EOFException();
    }

    public void close() throws IOException {
        synchronized (this.f29133b) {
            if (this.f29135d != null) {
                this.f29135d = null;
                this.f29133b.close();
            }
        }
    }

    public String e() throws IOException {
        int i11;
        byte[] bArr;
        int i12;
        synchronized (this.f29133b) {
            if (this.f29135d != null) {
                if (this.f29136e >= this.f29137f) {
                    b();
                }
                for (int i13 = this.f29136e; i13 != this.f29137f; i13++) {
                    byte[] bArr2 = this.f29135d;
                    if (bArr2[i13] == 10) {
                        int i14 = this.f29136e;
                        if (i13 != i14) {
                            i12 = i13 - 1;
                            if (bArr2[i12] == 13) {
                                String str = new String(bArr2, i14, i12 - i14, this.f29134c.name());
                                this.f29136e = i13 + 1;
                                return str;
                            }
                        }
                        i12 = i13;
                        String str2 = new String(bArr2, i14, i12 - i14, this.f29134c.name());
                        this.f29136e = i13 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f29137f - this.f29136e) + 80);
                loop1:
                while (true) {
                    byte[] bArr3 = this.f29135d;
                    int i15 = this.f29136e;
                    aVar.write(bArr3, i15, this.f29137f - i15);
                    this.f29137f = -1;
                    b();
                    i11 = this.f29136e;
                    while (true) {
                        if (i11 != this.f29137f) {
                            bArr = this.f29135d;
                            if (bArr[i11] == 10) {
                                break loop1;
                            }
                            i11++;
                        }
                    }
                }
                int i16 = this.f29136e;
                if (i11 != i16) {
                    aVar.write(bArr, i16, i11 - i16);
                }
                this.f29136e = i11 + 1;
                String byteArrayOutputStream = aVar.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public c(InputStream inputStream, int i11, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i11 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(d.f29139a)) {
            this.f29133b = inputStream;
            this.f29134c = charset;
            this.f29135d = new byte[i11];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
