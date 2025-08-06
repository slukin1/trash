package kotlinx.coroutines.debug.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlin.sequences.SequenceScope;

@d(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", l = {166}, m = "invokeSuspend")
public final class DebugCoroutineInfoImpl$creationStackTrace$1 extends RestrictedSuspendLambda implements p<SequenceScope<? super StackTraceElement>, c<? super Unit>, Object> {
    public final /* synthetic */ f $bottom;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ DebugCoroutineInfoImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$creationStackTrace$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, f fVar, c<? super DebugCoroutineInfoImpl$creationStackTrace$1> cVar) {
        super(2, cVar);
        this.this$0 = debugCoroutineInfoImpl;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        DebugCoroutineInfoImpl$creationStackTrace$1 debugCoroutineInfoImpl$creationStackTrace$1 = new DebugCoroutineInfoImpl$creationStackTrace$1(this.this$0, this.$bottom, cVar);
        debugCoroutineInfoImpl$creationStackTrace$1.L$0 = obj;
        return debugCoroutineInfoImpl$creationStackTrace$1;
    }

    public final Object invoke(SequenceScope<? super StackTraceElement> sequenceScope, c<? super Unit> cVar) {
        return ((DebugCoroutineInfoImpl$creationStackTrace$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            throw null;
        } else if (i11 == 1) {
            k.b(obj);
            return Unit.f56620a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
