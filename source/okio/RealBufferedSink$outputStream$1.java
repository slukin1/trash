package okio;

import com.huobi.points.entity.PointsPack;
import java.io.IOException;
import java.io.OutputStream;

public final class RealBufferedSink$outputStream$1 extends OutputStream {
    public final /* synthetic */ RealBufferedSink this$0;

    public RealBufferedSink$outputStream$1(RealBufferedSink realBufferedSink) {
        this.this$0 = realBufferedSink;
    }

    public void close() {
        this.this$0.close();
    }

    public void flush() {
        RealBufferedSink realBufferedSink = this.this$0;
        if (!realBufferedSink.closed) {
            realBufferedSink.flush();
        }
    }

    public String toString() {
        return this.this$0 + ".outputStream()";
    }

    public void write(int i11) {
        RealBufferedSink realBufferedSink = this.this$0;
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeByte((int) (byte) i11);
            this.this$0.emitCompleteSegments();
            return;
        }
        throw new IOException(PointsPack.STATE_CLOSED);
    }

    public void write(byte[] bArr, int i11, int i12) {
        RealBufferedSink realBufferedSink = this.this$0;
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i11, i12);
            this.this$0.emitCompleteSegments();
            return;
        }
        throw new IOException(PointsPack.STATE_CLOSED);
    }
}
