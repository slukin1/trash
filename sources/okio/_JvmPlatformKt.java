package okio;

import d10.a;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.InlineMarker;
import kotlin.text.b;

public final class _JvmPlatformKt {
    public static final byte[] asUtf8ToByteArray(String str) {
        return str.getBytes(b.f56908b);
    }

    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    public static final String toUtf8String(byte[] bArr) {
        return new String(bArr, b.f56908b);
    }

    public static final <T> T withLock(ReentrantLock reentrantLock, a<? extends T> aVar) {
        reentrantLock.lock();
        try {
            return aVar.invoke();
        } finally {
            InlineMarker.b(1);
            reentrantLock.unlock();
            InlineMarker.a(1);
        }
    }
}
