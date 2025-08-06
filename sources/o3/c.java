package o3;

import com.bumptech.glide.load.engine.bitmap_recycle.b;
import java.io.IOException;
import java.io.OutputStream;

public final class c extends OutputStream {

    /* renamed from: b  reason: collision with root package name */
    public final OutputStream f66516b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f66517c;

    /* renamed from: d  reason: collision with root package name */
    public b f66518d;

    /* renamed from: e  reason: collision with root package name */
    public int f66519e;

    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, 65536);
    }

    public final void a() throws IOException {
        int i11 = this.f66519e;
        if (i11 > 0) {
            this.f66516b.write(this.f66517c, 0, i11);
            this.f66519e = 0;
        }
    }

    public final void b() throws IOException {
        if (this.f66519e == this.f66517c.length) {
            a();
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f66516b.close();
            release();
        } catch (Throwable th2) {
            this.f66516b.close();
            throw th2;
        }
    }

    public void flush() throws IOException {
        a();
        this.f66516b.flush();
    }

    public final void release() {
        byte[] bArr = this.f66517c;
        if (bArr != null) {
            this.f66518d.put(bArr);
            this.f66517c = null;
        }
    }

    public void write(int i11) throws IOException {
        byte[] bArr = this.f66517c;
        int i12 = this.f66519e;
        this.f66519e = i12 + 1;
        bArr[i12] = (byte) i11;
        b();
    }

    public c(OutputStream outputStream, b bVar, int i11) {
        this.f66516b = outputStream;
        this.f66518d = bVar;
        this.f66517c = (byte[]) bVar.c(i11, byte[].class);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        do {
            int i14 = i12 - i13;
            int i15 = i11 + i13;
            int i16 = this.f66519e;
            if (i16 != 0 || i14 < this.f66517c.length) {
                int min = Math.min(i14, this.f66517c.length - i16);
                System.arraycopy(bArr, i15, this.f66517c, this.f66519e, min);
                this.f66519e += min;
                i13 += min;
                b();
            } else {
                this.f66516b.write(bArr, i15, i14);
                return;
            }
        } while (i13 < i12);
    }
}
