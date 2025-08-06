package androidx.datastore.rxjava3;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.p1;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H@"}, d2 = {"", "T", "Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@d(c = "androidx.datastore.rxjava3.RxDataStore$shutdownComplete$1", f = "RxDataStore.kt", l = {81}, m = "invokeSuspend")
final class RxDataStore$shutdownComplete$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ RxDataStore<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxDataStore$shutdownComplete$1(RxDataStore<Object> rxDataStore, c<? super RxDataStore$shutdownComplete$1> cVar) {
        super(2, cVar);
        this.this$0 = rxDataStore;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RxDataStore$shutdownComplete$1(this.this$0, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((RxDataStore$shutdownComplete$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            n1 k11 = p1.k(this.this$0.f9274c.getCoroutineContext());
            this.label = 1;
            if (k11.F(this) == d11) {
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
