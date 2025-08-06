package kotlinx.coroutines.reactive;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.reactive.PublisherCoroutine", f = "Publish.kt", l = {131}, m = "send")
public final class PublisherCoroutine$send$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ PublisherCoroutine<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublisherCoroutine$send$1(PublisherCoroutine<? super T> publisherCoroutine, c<? super PublisherCoroutine$send$1> cVar) {
        super(cVar);
        this.this$0 = publisherCoroutine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send(null, this);
    }
}
