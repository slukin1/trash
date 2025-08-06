package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.internal.ChannelFlow;

public final class CallbackFlowBuilder<T> extends c<T> {

    /* renamed from: f  reason: collision with root package name */
    public final p<k<? super T>, c<? super Unit>, Object> f57121f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallbackFlowBuilder(p pVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, r rVar) {
        this(pVar, (i12 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 4) != 0 ? -2 : i11, (i12 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object h(kotlinx.coroutines.channels.k<? super T> r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = (kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = new kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            kotlin.k.b(r6)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.k.b(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = super.h(r5, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            boolean r5 = r5.u()
            if (r5 == 0) goto L_0x004c
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.CallbackFlowBuilder.h(kotlinx.coroutines.channels.k, kotlin.coroutines.c):java.lang.Object");
    }

    public ChannelFlow<T> i(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return new CallbackFlowBuilder(this.f57121f, coroutineContext, i11, bufferOverflow);
    }

    public CallbackFlowBuilder(p<? super k<? super T>, ? super c<? super Unit>, ? extends Object> pVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(pVar, coroutineContext, i11, bufferOverflow);
        this.f57121f = pVar;
    }
}
