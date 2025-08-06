package kotlinx.coroutines.channels;

import d10.r;
import kotlin.jvm.internal.Lambda;

public final class BufferedChannel$sendImpl$1 extends Lambda implements r {
    public static final BufferedChannel$sendImpl$1 INSTANCE = new BufferedChannel$sendImpl$1();

    public BufferedChannel$sendImpl$1() {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((g<Object>) (g) obj, ((Number) obj2).intValue(), obj3, ((Number) obj4).longValue());
    }

    public final Void invoke(g<Object> gVar, int i11, Object obj, long j11) {
        throw new IllegalStateException("unexpected".toString());
    }
}
