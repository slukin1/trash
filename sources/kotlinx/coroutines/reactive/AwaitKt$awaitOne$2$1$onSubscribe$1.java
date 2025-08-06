package kotlinx.coroutines.reactive;

import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z20.d;

public final class AwaitKt$awaitOne$2$1$onSubscribe$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ d $sub;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitKt$awaitOne$2$1$onSubscribe$1(d dVar) {
        super(0);
        this.$sub = dVar;
    }

    public final void invoke() {
        this.$sub.cancel();
    }
}
