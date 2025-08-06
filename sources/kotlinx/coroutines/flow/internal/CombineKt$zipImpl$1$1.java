package kotlinx.coroutines.flow.internal;

import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", l = {126}, m = "invokeSuspend")
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ kotlinx.coroutines.flow.d<Object> $flow;
    public final /* synthetic */ kotlinx.coroutines.flow.d<Object> $flow2;
    public final /* synthetic */ e<Object> $this_unsafeFlow;
    public final /* synthetic */ q<Object, Object, c<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$1$1(e<Object> eVar, kotlinx.coroutines.flow.d<Object> dVar, kotlinx.coroutines.flow.d<Object> dVar2, q<Object, Object, ? super c<Object>, ? extends Object> qVar, c<? super CombineKt$zipImpl$1$1> cVar) {
        super(2, cVar);
        this.$this_unsafeFlow = eVar;
        this.$flow2 = dVar;
        this.$flow = dVar2;
        this.$transform = qVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, cVar);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((CombineKt$zipImpl$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r8 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r8.label
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L_0x0026
            if (r1 != r9) goto L_0x001e
            java.lang.Object r0 = r8.L$0
            r1 = r0
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            kotlin.k.b(r20)     // Catch:{ AbortFlowException -> 0x001b }
            goto L_0x0086
        L_0x0018:
            r0 = move-exception
            goto L_0x009e
        L_0x001b:
            r0 = move-exception
            goto L_0x0095
        L_0x001e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0026:
            kotlin.k.b(r20)
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
            r3 = 0
            r4 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1
            kotlinx.coroutines.flow.d<java.lang.Object> r2 = r8.$flow2
            r5.<init>(r2, r10)
            r6 = 3
            r7 = 0
            r2 = r1
            kotlinx.coroutines.channels.ReceiveChannel r7 = kotlinx.coroutines.channels.ProduceKt.d(r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.w r2 = kotlinx.coroutines.r1.b(r10, r9, r10)
            r3 = r7
            kotlinx.coroutines.channels.m r3 = (kotlinx.coroutines.channels.m) r3
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1
            kotlinx.coroutines.flow.e<java.lang.Object> r5 = r8.$this_unsafeFlow
            r4.<init>(r2, r5)
            r3.H(r4)
            kotlin.coroutines.CoroutineContext r13 = r1.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.b(r13)     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlin.coroutines.CoroutineContext r1 = r1.plus(r2)     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r3 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlinx.coroutines.flow.d<java.lang.Object> r12 = r8.$flow     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            kotlinx.coroutines.flow.e<java.lang.Object> r5 = r8.$this_unsafeFlow     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            d10.q<java.lang.Object, java.lang.Object, kotlin.coroutines.c<java.lang.Object>, java.lang.Object> r6 = r8.$transform     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r18 = 0
            r11 = r4
            r15 = r7
            r16 = r5
            r17 = r6
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r6 = 4
            r11 = 0
            r8.L$0 = r7     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r8.label = r9     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008e }
            r5 = r19
            r12 = r7
            r7 = r11
            java.lang.Object r1 = kotlinx.coroutines.flow.internal.b.d(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ AbortFlowException -> 0x008c, all -> 0x008a }
            if (r1 != r0) goto L_0x0085
            return r0
        L_0x0085:
            r1 = r12
        L_0x0086:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r1, r10, r9, r10)
            goto L_0x009b
        L_0x008a:
            r0 = move-exception
            goto L_0x0090
        L_0x008c:
            r0 = move-exception
            goto L_0x0094
        L_0x008e:
            r0 = move-exception
            r12 = r7
        L_0x0090:
            r1 = r12
            goto L_0x009e
        L_0x0092:
            r0 = move-exception
            r12 = r7
        L_0x0094:
            r1 = r12
        L_0x0095:
            kotlinx.coroutines.flow.e<java.lang.Object> r2 = r8.$this_unsafeFlow     // Catch:{ all -> 0x0018 }
            kotlinx.coroutines.flow.internal.g.a(r0, r2)     // Catch:{ all -> 0x0018 }
            goto L_0x0086
        L_0x009b:
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        L_0x009e:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r1, r10, r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
