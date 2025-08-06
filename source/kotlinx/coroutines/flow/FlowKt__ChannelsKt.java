package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.b;
import kotlinx.coroutines.h0;

public final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object b(e<? super T> eVar, ReceiveChannel<? extends T> receiveChannel, c<? super Unit> cVar) {
        Object c11 = c(eVar, receiveChannel, true, cVar);
        return c11 == IntrinsicsKt__IntrinsicsKt.d() ? c11 : Unit.f56620a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009e, code lost:
        if (r9 != false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a0, code lost:
        kotlinx.coroutines.channels.h.b(r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a3, code lost:
        throw r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[Catch:{ all -> 0x009d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071 A[Catch:{ all -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e A[Catch:{ all -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object c(kotlinx.coroutines.flow.e<? super T> r7, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r8, boolean r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            boolean r9 = r0.Z$0
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
            kotlin.k.b(r10)     // Catch:{ all -> 0x009b }
        L_0x0039:
            r10 = r7
            r7 = r2
            goto L_0x0060
        L_0x003c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0044:
            boolean r9 = r0.Z$0
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
            kotlin.k.b(r10)     // Catch:{ all -> 0x009b }
            goto L_0x0075
        L_0x0056:
            kotlin.k.b(r10)
            kotlinx.coroutines.flow.f.x(r7)
            kotlinx.coroutines.channels.ChannelIterator r10 = r8.iterator()     // Catch:{ all -> 0x009b }
        L_0x0060:
            r0.L$0 = r7     // Catch:{ all -> 0x009b }
            r0.L$1 = r8     // Catch:{ all -> 0x009b }
            r0.L$2 = r10     // Catch:{ all -> 0x009b }
            r0.Z$0 = r9     // Catch:{ all -> 0x009b }
            r0.label = r4     // Catch:{ all -> 0x009b }
            java.lang.Object r2 = r10.a(r0)     // Catch:{ all -> 0x009b }
            if (r2 != r1) goto L_0x0071
            return r1
        L_0x0071:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L_0x0075:
            r5 = 0
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x009b }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x009b }
            if (r10 == 0) goto L_0x0093
            java.lang.Object r10 = r7.next()     // Catch:{ all -> 0x009b }
            r0.L$0 = r2     // Catch:{ all -> 0x009b }
            r0.L$1 = r8     // Catch:{ all -> 0x009b }
            r0.L$2 = r7     // Catch:{ all -> 0x009b }
            r0.Z$0 = r9     // Catch:{ all -> 0x009b }
            r0.label = r3     // Catch:{ all -> 0x009b }
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch:{ all -> 0x009b }
            if (r10 != r1) goto L_0x0039
            return r1
        L_0x0093:
            if (r9 == 0) goto L_0x0098
            kotlinx.coroutines.channels.h.b(r8, r5)
        L_0x0098:
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        L_0x009b:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x009d }
        L_0x009d:
            r10 = move-exception
            if (r9 == 0) goto L_0x00a3
            kotlinx.coroutines.channels.h.b(r8, r7)
        L_0x00a3:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.c(kotlinx.coroutines.flow.e, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> ReceiveChannel<T> d(d<? extends T> dVar, h0 h0Var) {
        return b.b(dVar).m(h0Var);
    }

    public static final <T> d<T> e(ReceiveChannel<? extends T> receiveChannel) {
        return new b(receiveChannel, false, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (r) null);
    }
}
