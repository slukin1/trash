package kotlinx.coroutines.reactive;

import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.k;

final /* synthetic */ class PublisherCoroutine$onSend$1 extends FunctionReferenceImpl implements q<PublisherCoroutine<?>, k<?>, Object, Unit> {
    public static final PublisherCoroutine$onSend$1 INSTANCE = new PublisherCoroutine$onSend$1();

    public PublisherCoroutine$onSend$1() {
        super(3, PublisherCoroutine.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((PublisherCoroutine<?>) (PublisherCoroutine) obj, (k<?>) (k) obj2, obj3);
        return Unit.f56620a;
    }

    public final void invoke(PublisherCoroutine<?> publisherCoroutine, k<?> kVar, Object obj) {
        publisherCoroutine.n1(kVar, obj);
    }
}
