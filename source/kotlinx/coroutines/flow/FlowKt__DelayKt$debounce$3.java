package kotlinx.coroutines.flow;

import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlin.time.b;
import kotlinx.coroutines.DelayKt;

final class FlowKt__DelayKt$debounce$3 extends Lambda implements l<Object, Long> {
    public final /* synthetic */ l<Object, b> $timeout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounce$3(l<Object, b> lVar) {
        super(1);
        this.$timeout = lVar;
    }

    public final Long invoke(Object obj) {
        return Long.valueOf(DelayKt.d(this.$timeout.invoke(obj).J()));
    }
}
