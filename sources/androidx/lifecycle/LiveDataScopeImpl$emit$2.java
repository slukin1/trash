package androidx.lifecycle;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", l = {99}, m = "invokeSuspend")
public final class LiveDataScopeImpl$emit$2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ T $value;
    public int label;
    public final /* synthetic */ LiveDataScopeImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDataScopeImpl$emit$2(LiveDataScopeImpl<T> liveDataScopeImpl, T t11, c<? super LiveDataScopeImpl$emit$2> cVar) {
        super(2, cVar);
        this.this$0 = liveDataScopeImpl;
        this.$value = t11;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new LiveDataScopeImpl$emit$2(this.this$0, this.$value, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((LiveDataScopeImpl$emit$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            this.this$0.a();
            this.label = 1;
            throw null;
        } else if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            k.b(obj);
            this.this$0.a();
            throw null;
        }
    }
}
