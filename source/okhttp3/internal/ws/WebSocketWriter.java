package okhttp3.internal.ws;

import com.huobi.points.entity.PointsPack;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageBuffer = new Buffer();
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z11, BufferedSink bufferedSink, Random random2, boolean z12, boolean z13, long j11) {
        this.isClient = z11;
        this.sink = bufferedSink;
        this.random = random2;
        this.perMessageDeflate = z12;
        this.noContextTakeover = z13;
        this.minimumDeflateSize = j11;
        this.sinkBuffer = bufferedSink.getBuffer();
        Buffer.UnsafeCursor unsafeCursor = null;
        this.maskKey = z11 ? new byte[4] : null;
        this.maskCursor = z11 ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    private final void writeControlFrame(int i11, ByteString byteString) throws IOException {
        if (!this.writerClosed) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.sinkBuffer.writeByte(i11 | 128);
                if (this.isClient) {
                    this.sinkBuffer.writeByte(size | 128);
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.write(this.maskKey);
                    if (size > 0) {
                        long size2 = this.sinkBuffer.size();
                        this.sinkBuffer.write(byteString);
                        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                        this.maskCursor.seek(size2);
                        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.writeByte(size);
                    this.sinkBuffer.write(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        throw new IOException(PointsPack.STATE_CLOSED);
    }

    public void close() {
        MessageDeflater messageDeflater2 = this.messageDeflater;
        if (messageDeflater2 != null) {
            messageDeflater2.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int i11, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i11 == 0 && byteString == null)) {
            if (i11 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i11);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i11);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i11, ByteString byteString) throws IOException {
        if (!this.writerClosed) {
            this.messageBuffer.write(byteString);
            int i12 = 128;
            int i13 = i11 | 128;
            if (this.perMessageDeflate && ((long) byteString.size()) >= this.minimumDeflateSize) {
                MessageDeflater messageDeflater2 = this.messageDeflater;
                if (messageDeflater2 == null) {
                    messageDeflater2 = new MessageDeflater(this.noContextTakeover);
                    this.messageDeflater = messageDeflater2;
                }
                messageDeflater2.deflate(this.messageBuffer);
                i13 |= 64;
            }
            long size = this.messageBuffer.size();
            this.sinkBuffer.writeByte(i13);
            if (!this.isClient) {
                i12 = 0;
            }
            if (size <= 125) {
                this.sinkBuffer.writeByte(((int) size) | i12);
            } else if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                this.sinkBuffer.writeByte(i12 | 126);
                this.sinkBuffer.writeShort((int) size);
            } else {
                this.sinkBuffer.writeByte(i12 | 127);
                this.sinkBuffer.writeLong(size);
            }
            if (this.isClient) {
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.write(this.maskKey);
                if (size > 0) {
                    this.messageBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(0);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            this.sinkBuffer.write(this.messageBuffer, size);
            this.sink.emit();
            return;
        }
        throw new IOException(PointsPack.STATE_CLOSED);
    }

    public final void writePing(ByteString byteString) throws IOException {
        writeControlFrame(9, byteString);
    }

    public final void writePong(ByteString byteString) throws IOException {
        writeControlFrame(10, byteString);
    }
}
