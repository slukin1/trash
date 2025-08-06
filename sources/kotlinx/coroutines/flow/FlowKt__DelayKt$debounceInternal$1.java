package kotlinx.coroutines.flow;

import d10.l;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", l = {221, 426}, m = "invokeSuspend")
public final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements q<h0, e<? super T>, c<? super Unit>, Object> {
    public final /* synthetic */ d<T> $this_debounceInternal;
    public final /* synthetic */ l<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1(l<? super T, Long> lVar, d<? extends T> dVar, c<? super FlowKt__DelayKt$debounceInternal$1> cVar) {
        super(3, cVar);
        this.$timeoutMillisSelector = lVar;
        this.$this_debounceInternal = dVar;
    }

    public final Object invoke(h0 h0Var, e<? super T> eVar, c<? super Unit> cVar) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, cVar);
        flowKt__DelayKt$debounceInternal$1.L$0 = h0Var;
        flowKt__DelayKt$debounceInternal$1.L$1 = eVar;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 0
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0047
            if (r2 == r7) goto L_0x0030
            if (r2 != r4) goto L_0x0028
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.flow.e r10 = (kotlinx.coroutines.flow.e) r10
            kotlin.k.b(r19)
            r11 = r10
            r10 = r9
            r9 = r2
            r2 = r0
            goto L_0x006e
        L_0x0028:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0030:
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref$LongRef) r2
            java.lang.Object r9 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref$ObjectRef) r9
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r0.L$0
            kotlinx.coroutines.flow.e r11 = (kotlinx.coroutines.flow.e) r11
            kotlin.k.b(r19)
            r12 = r2
            r2 = r0
            goto L_0x00b5
        L_0x0047:
            kotlin.k.b(r19)
            java.lang.Object r2 = r0.L$0
            r9 = r2
            kotlinx.coroutines.h0 r9 = (kotlinx.coroutines.h0) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
            r10 = 0
            r11 = 0
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 r12 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1
            kotlinx.coroutines.flow.d<T> r13 = r0.$this_debounceInternal
            r12.<init>(r13, r8)
            r13 = 3
            r14 = 0
            kotlinx.coroutines.channels.ReceiveChannel r9 = kotlinx.coroutines.channels.ProduceKt.d(r9, r10, r11, r12, r13, r14)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r11 = r2
            r2 = r0
            r17 = r10
            r10 = r9
            r9 = r17
        L_0x006e:
            T r12 = r9.element
            kotlinx.coroutines.internal.c0 r13 = kotlinx.coroutines.flow.internal.k.f57267c
            if (r12 == r13) goto L_0x0121
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            T r13 = r9.element
            if (r13 == 0) goto L_0x00b7
            d10.l<T, java.lang.Long> r14 = r2.$timeoutMillisSelector
            kotlinx.coroutines.internal.c0 r15 = kotlinx.coroutines.flow.internal.k.f57265a
            if (r13 != r15) goto L_0x0084
            r13 = r8
        L_0x0084:
            java.lang.Object r13 = r14.invoke(r13)
            java.lang.Number r13 = (java.lang.Number) r13
            long r13 = r13.longValue()
            r12.element = r13
            int r16 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r16 < 0) goto L_0x0097
            r16 = r7
            goto L_0x0099
        L_0x0097:
            r16 = r3
        L_0x0099:
            if (r16 == 0) goto L_0x00bd
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x00b7
            T r13 = r9.element
            if (r13 != r15) goto L_0x00a4
            r13 = r8
        L_0x00a4:
            r2.L$0 = r11
            r2.L$1 = r10
            r2.L$2 = r9
            r2.L$3 = r12
            r2.label = r7
            java.lang.Object r13 = r11.emit(r13, r2)
            if (r13 != r1) goto L_0x00b5
            return r1
        L_0x00b5:
            r9.element = r8
        L_0x00b7:
            r17 = r9
            r9 = r2
            r2 = r17
            goto L_0x00c9
        L_0x00bd:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Debounce timeout should not be negative"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00c9:
            boolean r13 = kotlinx.coroutines.j0.a()
            if (r13 == 0) goto L_0x00e6
            T r13 = r2.element
            if (r13 == 0) goto L_0x00dc
            long r13 = r12.element
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x00da
            goto L_0x00dc
        L_0x00da:
            r13 = r3
            goto L_0x00dd
        L_0x00dc:
            r13 = r7
        L_0x00dd:
            if (r13 == 0) goto L_0x00e0
            goto L_0x00e6
        L_0x00e0:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x00e6:
            kotlinx.coroutines.selects.SelectImplementation r13 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r14 = r9.getContext()
            r13.<init>(r14)
            T r14 = r2.element
            if (r14 == 0) goto L_0x00fd
            long r14 = r12.element
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r12 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1
            r12.<init>(r11, r2, r8)
            kotlinx.coroutines.selects.a.a(r13, r14, r12)
        L_0x00fd:
            kotlinx.coroutines.selects.f r12 = r10.r()
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r14 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2
            r14.<init>(r2, r11, r8)
            r13.c(r12, r14)
            r9.L$0 = r11
            r9.L$1 = r10
            r9.L$2 = r2
            r9.L$3 = r8
            r9.label = r4
            java.lang.Object r12 = r13.r(r9)
            if (r12 != r1) goto L_0x011a
            return r1
        L_0x011a:
            r17 = r9
            r9 = r2
            r2 = r17
            goto L_0x006e
        L_0x0121:
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
