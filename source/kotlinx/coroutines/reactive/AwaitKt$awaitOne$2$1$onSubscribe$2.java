package kotlinx.coroutines.reactive;

import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import z20.d;

public final class AwaitKt$awaitOne$2$1$onSubscribe$2 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ d $sub;
    public final /* synthetic */ AwaitKt$awaitOne$2$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitKt$awaitOne$2$1$onSubscribe$2(AwaitKt$awaitOne$2$1 awaitKt$awaitOne$2$1, d dVar) {
        super(1);
        this.this$0 = awaitKt$awaitOne$2$1;
        this.$sub = dVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        AwaitKt$awaitOne$2$1 awaitKt$awaitOne$2$1 = this.this$0;
        final d dVar = this.$sub;
        awaitKt$awaitOne$2$1.c(new a<Unit>() {
            public final void invoke() {
                dVar.cancel();
            }
        });
    }
}
