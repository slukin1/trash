package kotlinx.coroutines.reactive;

import d10.q;
import kotlin.jvm.internal.FunctionReferenceImpl;

final /* synthetic */ class PublisherCoroutine$onSend$2 extends FunctionReferenceImpl implements q<PublisherCoroutine<?>, Object, Object, Object> {
    public static final PublisherCoroutine$onSend$2 INSTANCE = new PublisherCoroutine$onSend$2();

    public PublisherCoroutine$onSend$2() {
        super(3, PublisherCoroutine.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(PublisherCoroutine<?> publisherCoroutine, Object obj, Object obj2) {
        return publisherCoroutine.m1(obj, obj2);
    }
}
