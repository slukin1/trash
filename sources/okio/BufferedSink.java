package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    void flush() throws IOException;

    Buffer getBuffer();

    OutputStream outputStream();

    BufferedSink write(ByteString byteString) throws IOException;

    BufferedSink write(ByteString byteString, int i11, int i12) throws IOException;

    BufferedSink write(Source source, long j11) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i11, int i12) throws IOException;

    long writeAll(Source source) throws IOException;

    BufferedSink writeByte(int i11) throws IOException;

    BufferedSink writeDecimalLong(long j11) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long j11) throws IOException;

    BufferedSink writeInt(int i11) throws IOException;

    BufferedSink writeIntLe(int i11) throws IOException;

    BufferedSink writeLong(long j11) throws IOException;

    BufferedSink writeLongLe(long j11) throws IOException;

    BufferedSink writeShort(int i11) throws IOException;

    BufferedSink writeShortLe(int i11) throws IOException;

    BufferedSink writeString(String str, int i11, int i12, Charset charset) throws IOException;

    BufferedSink writeString(String str, Charset charset) throws IOException;

    BufferedSink writeUtf8(String str) throws IOException;

    BufferedSink writeUtf8(String str, int i11, int i12) throws IOException;

    BufferedSink writeUtf8CodePoint(int i11) throws IOException;
}
