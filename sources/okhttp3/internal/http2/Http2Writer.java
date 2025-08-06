package okhttp3.internal.http2;

import com.huobi.points.entity.PointsPack;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.r;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion((r) null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize = 16384;
    private final BufferedSink sink;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public Http2Writer(BufferedSink bufferedSink, boolean z11) {
        this.sink = bufferedSink;
        this.client = z11;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, (r) null);
    }

    private final void writeContinuationFrames(int i11, long j11) throws IOException {
        while (j11 > 0) {
            long min = Math.min((long) this.maxFrameSize, j11);
            j11 -= min;
            frameHeader(i11, (int) min, 9, j11 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (!this.closed) {
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }

    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException(PointsPack.STATE_CLOSED);
        } else if (this.client) {
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
            }
            this.sink.write(Http2.CONNECTION_PREFACE);
            this.sink.flush();
        }
    }

    public final synchronized void data(boolean z11, int i11, Buffer buffer, int i12) throws IOException {
        if (!this.closed) {
            dataFrame(i11, z11 ? 1 : 0, buffer, i12);
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }

    public final void dataFrame(int i11, int i12, Buffer buffer, int i13) throws IOException {
        frameHeader(i11, i13, 0, i12);
        if (i13 > 0) {
            this.sink.write(buffer, (long) i13);
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }

    public final void frameHeader(int i11, int i12, int i13, int i14) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i11, i12, i13, i14));
        }
        boolean z11 = true;
        if (i12 <= this.maxFrameSize) {
            if ((Integer.MIN_VALUE & i11) != 0) {
                z11 = false;
            }
            if (z11) {
                Util.writeMedium(this.sink, i12);
                this.sink.writeByte(i13 & 255);
                this.sink.writeByte(i14 & 255);
                this.sink.writeInt(i11 & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(("reserved bit set: " + i11).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + l.f34627b + i12).toString());
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i11, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (!this.closed) {
            boolean z11 = false;
            if (errorCode.getHttpCode() != -1) {
                frameHeader(0, bArr.length + 8, 7, 0);
                this.sink.writeInt(i11);
                this.sink.writeInt(errorCode.getHttpCode());
                if (bArr.length == 0) {
                    z11 = true;
                }
                if (!z11) {
                    this.sink.write(bArr);
                }
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }

    public final synchronized void headers(boolean z11, int i11, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            long min = Math.min((long) this.maxFrameSize, size);
            int i12 = (size > min ? 1 : (size == min ? 0 : -1));
            int i13 = i12 == 0 ? 4 : 0;
            if (z11) {
                i13 |= 1;
            }
            frameHeader(i11, (int) min, 1, i13);
            this.sink.write(this.hpackBuffer, min);
            if (i12 > 0) {
                writeContinuationFrames(i11, size - min);
            }
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z11, int i11, int i12) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, 6, z11 ? 1 : 0);
            this.sink.writeInt(i11);
            this.sink.writeInt(i12);
            this.sink.flush();
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }

    public final synchronized void pushPromise(int i11, int i12, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(((long) this.maxFrameSize) - 4, size);
            int i13 = min + 4;
            long j11 = (long) min;
            int i14 = (size > j11 ? 1 : (size == j11 ? 0 : -1));
            frameHeader(i11, i13, 5, i14 == 0 ? 4 : 0);
            this.sink.writeInt(i12 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j11);
            if (i14 > 0) {
                writeContinuationFrames(i11, size - j11);
            }
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }

    public final synchronized void rstStream(int i11, ErrorCode errorCode) throws IOException {
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                frameHeader(i11, 4, 3, 0);
                this.sink.writeInt(errorCode.getHttpCode());
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }

    public final synchronized void settings(Settings settings) throws IOException {
        if (!this.closed) {
            int i11 = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i11 < 10) {
                if (settings.isSet(i11)) {
                    this.sink.writeShort(i11 != 4 ? i11 != 7 ? i11 : 4 : 3);
                    this.sink.writeInt(settings.get(i11));
                }
                i11++;
            }
            this.sink.flush();
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }

    public final synchronized void windowUpdate(int i11, long j11) throws IOException {
        if (!this.closed) {
            if (j11 != 0 && j11 <= 2147483647L) {
                frameHeader(i11, 4, 8, 0);
                this.sink.writeInt((int) j11);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j11).toString());
            }
        } else {
            throw new IOException(PointsPack.STATE_CLOSED);
        }
    }
}
