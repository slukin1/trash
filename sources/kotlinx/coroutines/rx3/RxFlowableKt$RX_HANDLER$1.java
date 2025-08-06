package kotlinx.coroutines.rx3;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.FunctionReferenceImpl;

final /* synthetic */ class RxFlowableKt$RX_HANDLER$1 extends FunctionReferenceImpl implements p<Throwable, CoroutineContext, Unit> {
    public static final RxFlowableKt$RX_HANDLER$1 INSTANCE = new RxFlowableKt$RX_HANDLER$1();

    public RxFlowableKt$RX_HANDLER$1() {
        super(2, b.class, "handleUndeliverableException", "handleUndeliverableException(Ljava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)V", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (CoroutineContext) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, CoroutineContext coroutineContext) {
        b.a(th2, coroutineContext);
    }
}
