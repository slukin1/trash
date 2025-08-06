package okio;

import java.io.OutputStream;

public final class Buffer$outputStream$1 extends OutputStream {
    public final /* synthetic */ Buffer this$0;

    public Buffer$outputStream$1(Buffer buffer) {
        this.this$0 = buffer;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.this$0 + ".outputStream()";
    }

    public void write(int i11) {
        this.this$0.writeByte(i11);
    }

    public void write(byte[] bArr, int i11, int i12) {
        this.this$0.write(bArr, i11, i12);
    }
}
