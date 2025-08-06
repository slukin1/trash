package kotlinx.coroutines.rx3;

import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.k;

final /* synthetic */ class RxObservableCoroutine$onSend$1 extends FunctionReferenceImpl implements q<RxObservableCoroutine<?>, k<?>, Object, Unit> {
    public static final RxObservableCoroutine$onSend$1 INSTANCE = new RxObservableCoroutine$onSend$1();

    public RxObservableCoroutine$onSend$1() {
        super(3, RxObservableCoroutine.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RxObservableCoroutine<?>) (RxObservableCoroutine) obj, (k<?>) (k) obj2, obj3);
        return Unit.f56620a;
    }

    public final void invoke(RxObservableCoroutine<?> rxObservableCoroutine, k<?> kVar, Object obj) {
        rxObservableCoroutine.n1(kVar, obj);
    }
}
