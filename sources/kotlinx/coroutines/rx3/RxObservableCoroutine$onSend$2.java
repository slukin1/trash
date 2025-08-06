package kotlinx.coroutines.rx3;

import d10.q;
import kotlin.jvm.internal.FunctionReferenceImpl;

final /* synthetic */ class RxObservableCoroutine$onSend$2 extends FunctionReferenceImpl implements q<RxObservableCoroutine<?>, Object, Object, Object> {
    public static final RxObservableCoroutine$onSend$2 INSTANCE = new RxObservableCoroutine$onSend$2();

    public RxObservableCoroutine$onSend$2() {
        super(3, RxObservableCoroutine.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(RxObservableCoroutine<?> rxObservableCoroutine, Object obj, Object obj2) {
        return rxObservableCoroutine.m1(obj, obj2);
    }
}
