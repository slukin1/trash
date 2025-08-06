package kotlinx.coroutines.reactive;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;

@d(c = "kotlinx.coroutines.reactive.PublisherAsFlow$collectSlowPath$2", f = "ReactiveFlow.kt", l = {87}, m = "invokeSuspend")
final class PublisherAsFlow$collectSlowPath$2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ e<Object> $collector;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ c<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublisherAsFlow$collectSlowPath$2(e<Object> eVar, c<Object> cVar, c<? super PublisherAsFlow$collectSlowPath$2> cVar2) {
        super(2, cVar2);
        this.$collector = eVar;
        this.this$0 = cVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        PublisherAsFlow$collectSlowPath$2 publisherAsFlow$collectSlowPath$2 = new PublisherAsFlow$collectSlowPath$2(this.$collector, this.this$0, cVar);
        publisherAsFlow$collectSlowPath$2.L$0 = obj;
        return publisherAsFlow$collectSlowPath$2;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((PublisherAsFlow$collectSlowPath$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            e<Object> eVar = this.$collector;
            c<Object> cVar = this.this$0;
            ReceiveChannel<Object> m11 = cVar.m(i0.j((h0) this.L$0, cVar.f57236b));
            this.label = 1;
            if (f.v(eVar, m11, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
