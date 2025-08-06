package kotlinx.coroutines.rx3;

import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.rx3.DispatcherScheduler$scheduleDirect$1$1$1", f = "RxScheduler.kt", l = {60}, m = "invokeSuspend")
public final class DispatcherScheduler$scheduleDirect$1$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ l<c<? super Unit>, Object> $task;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DispatcherScheduler$scheduleDirect$1$1$1(l<? super c<? super Unit>, ? extends Object> lVar, c<? super DispatcherScheduler$scheduleDirect$1$1$1> cVar) {
        super(2, cVar);
        this.$task = lVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new DispatcherScheduler$scheduleDirect$1$1$1(this.$task, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((DispatcherScheduler$scheduleDirect$1$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            l<c<? super Unit>, Object> lVar = this.$task;
            this.label = 1;
            if (lVar.invoke(this) == d11) {
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
