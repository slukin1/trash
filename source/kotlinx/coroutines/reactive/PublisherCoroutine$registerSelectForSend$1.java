package kotlinx.coroutines.reactive;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.selects.k;
import kotlinx.coroutines.sync.a;

@d(c = "kotlinx.coroutines.reactive.PublisherCoroutine$registerSelectForSend$1", f = "Publish.kt", l = {107}, m = "invokeSuspend")
public final class PublisherCoroutine$registerSelectForSend$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ k<?> $select;
    public int label;
    public final /* synthetic */ PublisherCoroutine<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublisherCoroutine$registerSelectForSend$1(PublisherCoroutine<? super T> publisherCoroutine, k<?> kVar, c<? super PublisherCoroutine$registerSelectForSend$1> cVar) {
        super(2, cVar);
        this.this$0 = publisherCoroutine;
        this.$select = kVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new PublisherCoroutine$registerSelectForSend$1(this.this$0, this.$select, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((PublisherCoroutine$registerSelectForSend$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            kotlin.k.b(obj);
            a f12 = this.this$0.f57411g;
            this.label = 1;
            if (a.C0668a.a(f12, (Object) null, this, 1, (Object) null) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            kotlin.k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k<?> kVar = this.$select;
        PublisherCoroutine<T> publisherCoroutine = this.this$0;
        Unit unit = Unit.f56620a;
        if (!kVar.f(publisherCoroutine, unit)) {
            a.C0668a.c(this.this$0.f57411g, (Object) null, 1, (Object) null);
        }
        return unit;
    }
}
