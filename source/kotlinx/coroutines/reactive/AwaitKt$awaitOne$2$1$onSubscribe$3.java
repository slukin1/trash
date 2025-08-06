package kotlinx.coroutines.reactive;

import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z20.d;

public final class AwaitKt$awaitOne$2$1$onSubscribe$3 extends Lambda implements a<Unit> {
    public final /* synthetic */ Mode $mode;
    public final /* synthetic */ d $sub;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitKt$awaitOne$2$1$onSubscribe$3(d dVar, Mode mode) {
        super(0);
        this.$sub = dVar;
        this.$mode = mode;
    }

    public final void invoke() {
        d dVar = this.$sub;
        Mode mode = this.$mode;
        dVar.request((mode == Mode.FIRST || mode == Mode.FIRST_OR_DEFAULT) ? 1 : Long.MAX_VALUE);
    }
}
