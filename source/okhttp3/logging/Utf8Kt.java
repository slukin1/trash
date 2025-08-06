package okhttp3.logging;

import java.io.EOFException;
import okio.Buffer;

public final class Utf8Kt {
    public static final boolean isProbablyUtf8(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, RangesKt___RangesKt.h(buffer.size(), 64));
            for (int i11 = 0; i11 < 16; i11++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
