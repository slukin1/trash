package okio.internal;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    public FixedLengthSource(Source source, long j11, boolean z11) {
        super(source);
        this.size = j11;
        this.truncate = z11;
    }

    private final void truncateToSize(Buffer buffer, long j11) {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll(buffer);
        buffer.write(buffer2, j11);
        buffer2.clear();
    }

    public long read(Buffer buffer, long j11) {
        long j12 = this.bytesReceived;
        long j13 = this.size;
        if (j12 > j13) {
            j11 = 0;
        } else if (this.truncate) {
            long j14 = j13 - j12;
            if (j14 == 0) {
                return -1;
            }
            j11 = Math.min(j11, j14);
        }
        long read = super.read(buffer, j11);
        int i11 = (read > -1 ? 1 : (read == -1 ? 0 : -1));
        if (i11 != 0) {
            this.bytesReceived += read;
        }
        long j15 = this.bytesReceived;
        long j16 = this.size;
        if ((j15 >= j16 || i11 != 0) && j15 <= j16) {
            return read;
        }
        if (read > 0 && j15 > j16) {
            truncateToSize(buffer, buffer.size() - (this.bytesReceived - this.size));
        }
        throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
    }
}
