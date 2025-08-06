package kotlinx.coroutines.flow;

import d10.l;
import kotlin.jvm.internal.Lambda;

final class FlowKt__DelayKt$debounce$2 extends Lambda implements l<Object, Long> {
    public final /* synthetic */ long $timeoutMillis;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounce$2(long j11) {
        super(1);
        this.$timeoutMillis = j11;
    }

    public final Long invoke(Object obj) {
        return Long.valueOf(this.$timeoutMillis);
    }
}
