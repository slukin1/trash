package okio;

import com.huobi.points.entity.PointsPack;
import java.io.IOException;
import java.io.InputStream;

public final class RealBufferedSource$inputStream$1 extends InputStream {
    public final /* synthetic */ RealBufferedSource this$0;

    public RealBufferedSource$inputStream$1(RealBufferedSource realBufferedSource) {
        this.this$0 = realBufferedSource;
    }

    public int available() {
        RealBufferedSource realBufferedSource = this.this$0;
        if (!realBufferedSource.closed) {
            return (int) Math.min(realBufferedSource.bufferField.size(), (long) Integer.MAX_VALUE);
        }
        throw new IOException(PointsPack.STATE_CLOSED);
    }

    public void close() {
        this.this$0.close();
    }

    public int read() {
        RealBufferedSource realBufferedSource = this.this$0;
        if (!realBufferedSource.closed) {
            if (realBufferedSource.bufferField.size() == 0) {
                RealBufferedSource realBufferedSource2 = this.this$0;
                if (realBufferedSource2.source.read(realBufferedSource2.bufferField, 8192) == -1) {
                    return -1;
                }
            }
            return this.this$0.bufferField.readByte() & 255;
        }
        throw new IOException(PointsPack.STATE_CLOSED);
    }

    public String toString() {
        return this.this$0 + ".inputStream()";
    }

    public int read(byte[] bArr, int i11, int i12) {
        if (!this.this$0.closed) {
            SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i11, (long) i12);
            if (this.this$0.bufferField.size() == 0) {
                RealBufferedSource realBufferedSource = this.this$0;
                if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                    return -1;
                }
            }
            return this.this$0.bufferField.read(bArr, i11, i12);
        }
        throw new IOException(PointsPack.STATE_CLOSED);
    }
}
