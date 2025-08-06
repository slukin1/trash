package kotlinx.coroutines.channels;

import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.k;

public /* synthetic */ class LazyActorCoroutine$onSend$1 extends FunctionReferenceImpl implements q<LazyActorCoroutine<?>, k<?>, Object, Unit> {
    public static final LazyActorCoroutine$onSend$1 INSTANCE = new LazyActorCoroutine$onSend$1();

    public LazyActorCoroutine$onSend$1() {
        super(3, LazyActorCoroutine.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((LazyActorCoroutine<?>) (LazyActorCoroutine) obj, (k<?>) (k) obj2, obj3);
        return Unit.f56620a;
    }

    public final void invoke(LazyActorCoroutine<?> lazyActorCoroutine, k<?> kVar, Object obj) {
        lazyActorCoroutine.i1(kVar, obj);
    }
}
