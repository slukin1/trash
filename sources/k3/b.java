package k3;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class b implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final InputStream f66449b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f66450c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f66451d;

    /* renamed from: e  reason: collision with root package name */
    public int f66452e;

    /* renamed from: f  reason: collision with root package name */
    public int f66453f;

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
                return new String(this.buf, 0, i11, b.this.f66450c.name());
            } catch (UnsupportedEncodingException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void b() throws IOException {
        InputStream inputStream = this.f66449b;
        byte[] bArr = this.f66451d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f66452e = 0;
            this.f66453f = read;
            return;
        }
        throw new EOFException();
    }

    public void close() throws IOException {
        synchronized (this.f66449b) {
            if (this.f66451d != null) {
                this.f66451d = null;
                this.f66449b.close();
            }
        }
    }

    public boolean e() {
        return this.f66453f == -1;
    }

    public String f() throws IOException {
        int i11;
        byte[] bArr;
        int i12;
        synchronized (this.f66449b) {
            if (this.f66451d != null) {
                if (this.f66452e >= this.f66453f) {
                    b();
                }
                for (int i13 = this.f66452e; i13 != this.f66453f; i13++) {
                    byte[] bArr2 = this.f66451d;
                    if (bArr2[i13] == 10) {
                        int i14 = this.f66452e;
                        if (i13 != i14) {
                            i12 = i13 - 1;
                            if (bArr2[i12] == 13) {
                                String str = new String(bArr2, i14, i12 - i14, this.f66450c.name());
                                this.f66452e = i13 + 1;
                                return str;
                            }
                        }
                        i12 = i13;
                        String str2 = new String(bArr2, i14, i12 - i14, this.f66450c.name());
                        this.f66452e = i13 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f66453f - this.f66452e) + 80);
                loop1:
                while (true) {
                    byte[] bArr3 = this.f66451d;
                    int i15 = this.f66452e;
                    aVar.write(bArr3, i15, this.f66453f - i15);
                    this.f66453f = -1;
                    b();
                    i11 = this.f66452e;
                    while (true) {
                        if (i11 != this.f66453f) {
                            bArr = this.f66451d;
                            if (bArr[i11] == 10) {
                                break loop1;
                            }
                            i11++;
                        }
                    }
                }
                int i16 = this.f66452e;
                if (i11 != i16) {
                    aVar.write(bArr, i16, i11 - i16);
                }
                this.f66452e = i11 + 1;
                String byteArrayOutputStream = aVar.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public b(InputStream inputStream, int i11, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i11 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(c.f66455a)) {
            this.f66449b = inputStream;
            this.f66450c = charset;
            this.f66451d = new byte[i11];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
