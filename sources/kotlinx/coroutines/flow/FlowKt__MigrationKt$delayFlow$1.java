package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.DelayKt;

@d(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", f = "Migration.kt", l = {415}, m = "invokeSuspend")
final class FlowKt__MigrationKt$delayFlow$1 extends SuspendLambda implements p<e<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ long $timeMillis;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$delayFlow$1(long j11, c<? super FlowKt__MigrationKt$delayFlow$1> cVar) {
        super(2, cVar);
        this.$timeMillis = j11;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FlowKt__MigrationKt$delayFlow$1(this.$timeMillis, cVar);
    }

    public final Object invoke(e<Object> eVar, c<? super Unit> cVar) {
        return ((FlowKt__MigrationKt$delayFlow$1) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            long j11 = this.$timeMillis;
            this.label = 1;
            if (DelayKt.b(j11, this) == d11) {
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
