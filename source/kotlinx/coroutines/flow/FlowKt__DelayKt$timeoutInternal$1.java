package kotlinx.coroutines.flow;

import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", f = "Delay.kt", l = {424}, m = "invokeSuspend")
final class FlowKt__DelayKt$timeoutInternal$1 extends SuspendLambda implements q<h0, e<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ d<Object> $this_timeoutInternal;
    public final /* synthetic */ long $timeout;
    public long J$0;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$timeoutInternal$1(long j11, d<Object> dVar, c<? super FlowKt__DelayKt$timeoutInternal$1> cVar) {
        super(3, cVar);
        this.$timeout = j11;
        this.$this_timeoutInternal = dVar;
    }

    public final Object invoke(h0 h0Var, e<Object> eVar, c<? super Unit> cVar) {
        FlowKt__DelayKt$timeoutInternal$1 flowKt__DelayKt$timeoutInternal$1 = new FlowKt__DelayKt$timeoutInternal$1(this.$timeout, this.$this_timeoutInternal, cVar);
        flowKt__DelayKt$timeoutInternal$1.L$0 = h0Var;
        flowKt__DelayKt$timeoutInternal$1.L$1 = eVar;
        return flowKt__DelayKt$timeoutInternal$1.invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r11.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            long r4 = r11.J$0
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.flow.e r6 = (kotlinx.coroutines.flow.e) r6
            kotlin.k.b(r12)
            r7 = r6
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r11
            goto L_0x0084
        L_0x001f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0027:
            kotlin.k.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.h0 r12 = (kotlinx.coroutines.h0) r12
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
            long r4 = r11.$timeout
            kotlin.time.b$a r6 = kotlin.time.b.f56931c
            long r6 = r6.b()
            int r4 = kotlin.time.b.h(r4, r6)
            if (r4 <= 0) goto L_0x0095
            kotlinx.coroutines.flow.d<java.lang.Object> r4 = r11.$this_timeoutInternal
            r5 = 0
            r6 = 2
            kotlinx.coroutines.flow.d r4 = kotlinx.coroutines.flow.u.b(r4, r5, r3, r6, r3)
            kotlinx.coroutines.channels.ReceiveChannel r12 = kotlinx.coroutines.flow.f.S(r4, r12)
            long r4 = r11.$timeout
            r6 = r1
            r1 = r12
            r12 = r11
        L_0x0051:
            kotlinx.coroutines.selects.SelectImplementation r7 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r8 = r12.getContext()
            r7.<init>(r8)
            kotlinx.coroutines.selects.f r8 = r1.r()
            kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1 r9 = new kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1
            r9.<init>(r6, r3)
            r7.c(r8, r9)
            kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2 r8 = new kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2
            r8.<init>(r4, r3)
            kotlinx.coroutines.selects.a.b(r7, r4, r8)
            r12.L$0 = r6
            r12.L$1 = r1
            r12.J$0 = r4
            r12.label = r2
            java.lang.Object r7 = r7.r(r12)
            if (r7 != r0) goto L_0x007d
            return r0
        L_0x007d:
            r10 = r0
            r0 = r12
            r12 = r7
            r7 = r6
            r5 = r4
            r4 = r1
            r1 = r10
        L_0x0084:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x008f
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x008f:
            r12 = r0
            r0 = r1
            r1 = r4
            r4 = r5
            r6 = r7
            goto L_0x0051
        L_0x0095:
            kotlinx.coroutines.TimeoutCancellationException r12 = new kotlinx.coroutines.TimeoutCancellationException
            java.lang.String r0 = "Timed out immediately"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
