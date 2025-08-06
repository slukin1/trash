package ex;

import com.meituan.android.walle.SignatureNotFoundException;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;

public final class a {
    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static d<ByteBuffer, Long> b(FileChannel fileChannel) throws IOException, SignatureNotFoundException {
        return c(fileChannel, d(fileChannel));
    }

    public static d<ByteBuffer, Long> c(FileChannel fileChannel, long j11) throws IOException, SignatureNotFoundException {
        if (j11 >= 32) {
            fileChannel.position(j11 - 24);
            ByteBuffer allocate = ByteBuffer.allocate(24);
            fileChannel.read(allocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                long j12 = allocate.getLong(0);
                if (j12 < ((long) allocate.capacity()) || j12 > 2147483639) {
                    throw new SignatureNotFoundException("APK Signing Block size out of range: " + j12);
                }
                int i11 = (int) (8 + j12);
                long j13 = j11 - ((long) i11);
                if (j13 >= 0) {
                    fileChannel.position(j13);
                    ByteBuffer allocate2 = ByteBuffer.allocate(i11);
                    fileChannel.read(allocate2);
                    allocate2.order(byteOrder);
                    long j14 = allocate2.getLong(0);
                    if (j14 == j12) {
                        return d.b(allocate2, Long.valueOf(j13));
                    }
                    throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j14 + " vs " + j12);
                }
                throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j13);
            }
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j11);
    }

    public static long d(FileChannel fileChannel) throws IOException {
        return e(fileChannel, h(fileChannel));
    }

    public static long e(FileChannel fileChannel, long j11) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position((fileChannel.size() - j11) - 6);
        fileChannel.read(allocate);
        return (long) allocate.getInt(0);
    }

    public static Map<Integer, ByteBuffer> f(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        a(byteBuffer);
        ByteBuffer i11 = i(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i12 = 0;
        while (i11.hasRemaining()) {
            i12++;
            if (i11.remaining() >= 8) {
                long j11 = i11.getLong();
                if (j11 < 4 || j11 > 2147483647L) {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i12 + " size out of range: " + j11);
                }
                int i13 = (int) j11;
                int position = i11.position() + i13;
                if (i13 <= i11.remaining()) {
                    linkedHashMap.put(Integer.valueOf(i11.getInt()), g(i11, i13 - 4));
                    i11.position(position);
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i12 + " size out of range: " + i13 + ", available: " + i11.remaining());
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i12);
            }
        }
        return linkedHashMap;
    }

    public static ByteBuffer g(ByteBuffer byteBuffer, int i11) throws BufferUnderflowException {
        if (i11 >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i12 = i11 + position;
            if (i12 < position || i12 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i12);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i12);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            throw new IllegalArgumentException("size: " + i11);
        }
    }

    public static long h(FileChannel fileChannel) throws IOException {
        long size = fileChannel.size();
        if (size >= 22) {
            long j11 = size - 22;
            long min = Math.min(j11, WebSocketProtocol.PAYLOAD_SHORT_MAX);
            int i11 = 0;
            while (true) {
                long j12 = (long) i11;
                if (j12 <= min) {
                    long j13 = j11 - j12;
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    fileChannel.position(j13);
                    fileChannel.read(allocate);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    allocate.order(byteOrder);
                    if (allocate.getInt(0) == 101010256) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(2);
                        fileChannel.position(j13 + 20);
                        fileChannel.read(allocate2);
                        allocate2.order(byteOrder);
                        short s11 = allocate2.getShort(0);
                        if (s11 == i11) {
                            return (long) s11;
                        }
                    }
                    i11++;
                } else {
                    throw new IOException("ZIP End of Central Directory (EOCD) record not found");
                }
            }
        } else {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
    }

    /* JADX INFO: finally extract failed */
    public static ByteBuffer i(ByteBuffer byteBuffer, int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException("start: " + i11);
        } else if (i12 >= i11) {
            int capacity = byteBuffer.capacity();
            if (i12 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i12);
                    byteBuffer.position(i11);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    return slice;
                } catch (Throwable th2) {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    throw th2;
                }
            } else {
                throw new IllegalArgumentException("end > capacity: " + i12 + " > " + capacity);
            }
        } else {
            throw new IllegalArgumentException("end < start: " + i12 + " < " + i11);
        }
    }
}
