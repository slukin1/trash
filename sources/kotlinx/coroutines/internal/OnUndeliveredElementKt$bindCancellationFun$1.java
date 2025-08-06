package kotlinx.coroutines.internal;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

public final class OnUndeliveredElementKt$bindCancellationFun$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ CoroutineContext $context;
    public final /* synthetic */ E $element;
    public final /* synthetic */ l<E, Unit> $this_bindCancellationFun;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnUndeliveredElementKt$bindCancellationFun$1(l<? super E, Unit> lVar, E e11, CoroutineContext coroutineContext) {
        super(1);
        this.$this_bindCancellationFun = lVar;
        this.$element = e11;
        this.$context = coroutineContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        OnUndeliveredElementKt.b(this.$this_bindCancellationFun, this.$element, this.$context);
    }
}
