package m10;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.BaseInputStream;

public class c extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    public BaseInputStream f58113b;

    public c(BaseInputStream baseInputStream) {
        this.f58113b = baseInputStream;
    }

    public void a(boolean z11) throws IOException {
        try {
            this.f58113b.close();
            if (!z11 && this.f58113b.a() != null) {
                this.f58113b.a().b();
            }
        } catch (ZipException e11) {
            throw new IOException(e11.getMessage());
        }
    }

    public int available() throws IOException {
        return this.f58113b.available();
    }

    public void close() throws IOException {
        a(false);
    }

    public int read() throws IOException {
        int read = this.f58113b.read();
        if (read != -1) {
            this.f58113b.a().u(read);
        }
        return read;
    }

    public long skip(long j11) throws IOException {
        return this.f58113b.skip(j11);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = this.f58113b.read(bArr, i11, i12);
        if (read > 0 && this.f58113b.a() != null) {
            this.f58113b.a().v(bArr, i11, read);
        }
        return read;
    }
}
