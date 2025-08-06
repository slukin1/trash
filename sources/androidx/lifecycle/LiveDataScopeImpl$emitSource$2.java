package androidx.lifecycle;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.x0;

@d(c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", f = "CoroutineLiveData.kt", l = {94}, m = "invokeSuspend")
final class LiveDataScopeImpl$emitSource$2 extends SuspendLambda implements p<h0, c<? super x0>, Object> {
    public final /* synthetic */ LiveData<Object> $source;
    public int label;
    public final /* synthetic */ LiveDataScopeImpl<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDataScopeImpl$emitSource$2(LiveDataScopeImpl<Object> liveDataScopeImpl, LiveData<Object> liveData, c<? super LiveDataScopeImpl$emitSource$2> cVar) {
        super(2, cVar);
        this.this$0 = liveDataScopeImpl;
        this.$source = liveData;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new LiveDataScopeImpl$emitSource$2(this.this$0, this.$source, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super x0> cVar) {
        return ((LiveDataScopeImpl$emitSource$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            this.this$0.a();
            this.label = 1;
            throw null;
        } else if (i11 == 1) {
            k.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
