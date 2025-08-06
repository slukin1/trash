package okio;

import java.io.InputStream;

public final class Buffer$inputStream$1 extends InputStream {
    public final /* synthetic */ Buffer this$0;

    public Buffer$inputStream$1(Buffer buffer) {
        this.this$0 = buffer;
    }

    public int available() {
        return (int) Math.min(this.this$0.size(), (long) Integer.MAX_VALUE);
    }

    public void close() {
    }

    public int read() {
        if (this.this$0.size() > 0) {
            return this.this$0.readByte() & 255;
        }
        return -1;
    }

    public String toString() {
        return this.this$0 + ".inputStream()";
    }

    public int read(byte[] bArr, int i11, int i12) {
        return this.this$0.read(bArr, i11, i12);
    }
}
