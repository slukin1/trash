package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", l = {487, 333, 333}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements p<k<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ ReceiveChannel<Object> $this_map;
    public final /* synthetic */ p<Object, c<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<Object> receiveChannel, p<Object, ? super c<Object>, ? extends Object> pVar, c<? super ChannelsKt__DeprecatedKt$map$1> cVar) {
        super(2, cVar);
        this.$this_map = receiveChannel;
        this.$transform = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, cVar);
        channelsKt__DeprecatedKt$map$1.L$0 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }

    public final Object invoke(k<Object> kVar, c<? super Unit> cVar) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093 A[Catch:{ all -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r12.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0063
            if (r1 == r5) goto L_0x004e
            if (r1 == r4) goto L_0x0030
            if (r1 != r3) goto L_0x0028
            java.lang.Object r1 = r12.L$3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.L$2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.L$1
            d10.p r7 = (d10.p) r7
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.k r8 = (kotlinx.coroutines.channels.k) r8
            kotlin.k.b(r13)     // Catch:{ all -> 0x00cf }
            r13 = r8
            r8 = r12
            goto L_0x0076
        L_0x0028:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0030:
            java.lang.Object r1 = r12.L$4
            kotlinx.coroutines.channels.k r1 = (kotlinx.coroutines.channels.k) r1
            java.lang.Object r6 = r12.L$3
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.L$2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r12.L$1
            d10.p r8 = (d10.p) r8
            java.lang.Object r9 = r12.L$0
            kotlinx.coroutines.channels.k r9 = (kotlinx.coroutines.channels.k) r9
            kotlin.k.b(r13)     // Catch:{ all -> 0x004a }
            r10 = r12
            goto L_0x00b0
        L_0x004a:
            r13 = move-exception
            r6 = r7
            goto L_0x00d0
        L_0x004e:
            java.lang.Object r1 = r12.L$3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.L$2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.L$1
            d10.p r7 = (d10.p) r7
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.k r8 = (kotlinx.coroutines.channels.k) r8
            kotlin.k.b(r13)     // Catch:{ all -> 0x00cf }
            r9 = r12
            goto L_0x008b
        L_0x0063:
            kotlin.k.b(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.channels.k r13 = (kotlinx.coroutines.channels.k) r13
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r6 = r12.$this_map
            d10.p<java.lang.Object, kotlin.coroutines.c<java.lang.Object>, java.lang.Object> r1 = r12.$transform
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x00cf }
            r8 = r12
            r11 = r7
            r7 = r1
            r1 = r11
        L_0x0076:
            r8.L$0 = r13     // Catch:{ all -> 0x00cf }
            r8.L$1 = r7     // Catch:{ all -> 0x00cf }
            r8.L$2 = r6     // Catch:{ all -> 0x00cf }
            r8.L$3 = r1     // Catch:{ all -> 0x00cf }
            r8.label = r5     // Catch:{ all -> 0x00cf }
            java.lang.Object r9 = r1.a(r8)     // Catch:{ all -> 0x00cf }
            if (r9 != r0) goto L_0x0087
            return r0
        L_0x0087:
            r11 = r8
            r8 = r13
            r13 = r9
            r9 = r11
        L_0x008b:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x00cf }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x00cf }
            if (r13 == 0) goto L_0x00c9
            java.lang.Object r13 = r1.next()     // Catch:{ all -> 0x00cf }
            r9.L$0 = r8     // Catch:{ all -> 0x00cf }
            r9.L$1 = r7     // Catch:{ all -> 0x00cf }
            r9.L$2 = r6     // Catch:{ all -> 0x00cf }
            r9.L$3 = r1     // Catch:{ all -> 0x00cf }
            r9.L$4 = r8     // Catch:{ all -> 0x00cf }
            r9.label = r4     // Catch:{ all -> 0x00cf }
            java.lang.Object r13 = r7.invoke(r13, r9)     // Catch:{ all -> 0x00cf }
            if (r13 != r0) goto L_0x00aa
            return r0
        L_0x00aa:
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L_0x00b0:
            r10.L$0 = r9     // Catch:{ all -> 0x004a }
            r10.L$1 = r8     // Catch:{ all -> 0x004a }
            r10.L$2 = r7     // Catch:{ all -> 0x004a }
            r10.L$3 = r6     // Catch:{ all -> 0x004a }
            r10.L$4 = r2     // Catch:{ all -> 0x004a }
            r10.label = r3     // Catch:{ all -> 0x004a }
            java.lang.Object r13 = r1.send(r13, r10)     // Catch:{ all -> 0x004a }
            if (r13 != r0) goto L_0x00c3
            return r0
        L_0x00c3:
            r1 = r6
            r6 = r7
            r7 = r8
            r13 = r9
            r8 = r10
            goto L_0x0076
        L_0x00c9:
            kotlin.Unit r13 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00cf }
            kotlinx.coroutines.channels.h.b(r6, r2)
            return r13
        L_0x00cf:
            r13 = move-exception
        L_0x00d0:
            throw r13     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r0 = move-exception
            kotlinx.coroutines.channels.h.b(r6, r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
