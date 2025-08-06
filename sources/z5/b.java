package z5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import y5.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public final ByteBuffer f66731b;

    public b(ByteBuffer byteBuffer) {
        this.f66731b = byteBuffer;
        byteBuffer.position(0);
    }

    public InputStream a() throws IOException {
        return new ByteArrayInputStream(this.f66731b.array());
    }

    public int available() throws IOException {
        return this.f66731b.limit() - this.f66731b.position();
    }

    public int b() {
        return this.f66731b.position();
    }

    public void close() throws IOException {
    }

    public byte peek() throws IOException {
        return this.f66731b.get();
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        this.f66731b.get(bArr, i11, i12);
        return i12;
    }

    public void reset() throws IOException {
        this.f66731b.position(0);
    }

    public long skip(long j11) throws IOException {
        ByteBuffer byteBuffer = this.f66731b;
        byteBuffer.position((int) (((long) byteBuffer.position()) + j11));
        return j11;
    }
}
