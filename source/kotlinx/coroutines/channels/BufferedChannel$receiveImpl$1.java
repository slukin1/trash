package kotlinx.coroutines.channels;

import d10.q;
import kotlin.jvm.internal.Lambda;

public final class BufferedChannel$receiveImpl$1 extends Lambda implements q {
    public static final BufferedChannel$receiveImpl$1 INSTANCE = new BufferedChannel$receiveImpl$1();

    public BufferedChannel$receiveImpl$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((g<Object>) (g) obj, ((Number) obj2).intValue(), ((Number) obj3).longValue());
    }

    public final Void invoke(g<Object> gVar, int i11, long j11) {
        throw new IllegalStateException("unexpected".toString());
    }
}
