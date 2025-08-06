package kotlinx.coroutines.rx3;

import d10.l;
import io.reactivex.rxjava3.disposables.b;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class RxAwaitKt$awaitOne$2$1$onSubscribe$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ b $sub;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxAwaitKt$awaitOne$2$1$onSubscribe$1(b bVar) {
        super(1);
        this.$sub = bVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.$sub.dispose();
    }
}
