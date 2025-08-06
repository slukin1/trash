package kotlinx.coroutines.rx3;

import d10.l;
import io.reactivex.rxjava3.disposables.b;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class RxAwaitKt$disposeOnCancellation$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ b $d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxAwaitKt$disposeOnCancellation$1(b bVar) {
        super(1);
        this.$d = bVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.$d.dispose();
    }
}
