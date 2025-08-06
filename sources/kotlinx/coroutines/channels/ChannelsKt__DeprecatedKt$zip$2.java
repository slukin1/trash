package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", l = {487, 469, 471}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements p<k<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ ReceiveChannel<Object> $other;
    public final /* synthetic */ ReceiveChannel<Object> $this_zip;
    public final /* synthetic */ p<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<Object> receiveChannel, ReceiveChannel<Object> receiveChannel2, p<Object, Object, Object> pVar, c<? super ChannelsKt__DeprecatedKt$zip$2> cVar) {
        super(2, cVar);
        this.$other = receiveChannel;
        this.$this_zip = receiveChannel2;
        this.$transform = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, cVar);
        channelsKt__DeprecatedKt$zip$2.L$0 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    public final Object invoke(k<Object> kVar, c<? super Unit> cVar) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bd A[Catch:{ all -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r13.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x007d
            if (r1 == r4) goto L_0x005e
            if (r1 == r3) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            java.lang.Object r1 = r13.L$4
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r13.L$3
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r13.L$2
            d10.p r7 = (d10.p) r7
            java.lang.Object r8 = r13.L$1
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r13.L$0
            kotlinx.coroutines.channels.k r9 = (kotlinx.coroutines.channels.k) r9
            kotlin.k.b(r14)     // Catch:{ all -> 0x011b }
            r10 = r8
            r8 = r6
            r6 = r1
            r1 = r0
            r0 = r13
            goto L_0x0104
        L_0x0030:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0038:
            java.lang.Object r1 = r13.L$5
            java.lang.Object r6 = r13.L$4
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r13.L$3
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r13.L$2
            d10.p r8 = (d10.p) r8
            java.lang.Object r9 = r13.L$1
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r13.L$0
            kotlinx.coroutines.channels.k r10 = (kotlinx.coroutines.channels.k) r10
            kotlin.k.b(r14)     // Catch:{ all -> 0x005a }
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r1
            r1 = r0
            r0 = r13
            goto L_0x00dd
        L_0x005a:
            r14 = move-exception
            r6 = r7
            goto L_0x011c
        L_0x005e:
            java.lang.Object r1 = r13.L$4
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r13.L$3
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r13.L$2
            d10.p r7 = (d10.p) r7
            java.lang.Object r8 = r13.L$1
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r13.L$0
            kotlinx.coroutines.channels.k r9 = (kotlinx.coroutines.channels.k) r9
            kotlin.k.b(r14)     // Catch:{ all -> 0x011b }
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r13
            goto L_0x00b5
        L_0x007d:
            kotlin.k.b(r14)
            java.lang.Object r14 = r13.L$0
            kotlinx.coroutines.channels.k r14 = (kotlinx.coroutines.channels.k) r14
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r13.$other
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r6 = r13.$this_zip
            d10.p<java.lang.Object, java.lang.Object, java.lang.Object> r7 = r13.$transform
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x011b }
            r9 = r14
            r14 = r13
            r12 = r8
            r8 = r1
            r1 = r12
        L_0x0097:
            r14.L$0 = r9     // Catch:{ all -> 0x011b }
            r14.L$1 = r8     // Catch:{ all -> 0x011b }
            r14.L$2 = r7     // Catch:{ all -> 0x011b }
            r14.L$3 = r6     // Catch:{ all -> 0x011b }
            r14.L$4 = r1     // Catch:{ all -> 0x011b }
            r14.L$5 = r5     // Catch:{ all -> 0x011b }
            r14.label = r4     // Catch:{ all -> 0x011b }
            java.lang.Object r10 = r1.a(r14)     // Catch:{ all -> 0x011b }
            if (r10 != r0) goto L_0x00ac
            return r0
        L_0x00ac:
            r12 = r0
            r0 = r14
            r14 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r12
        L_0x00b5:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x005a }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x005a }
            if (r14 == 0) goto L_0x0115
            java.lang.Object r14 = r6.next()     // Catch:{ all -> 0x005a }
            r0.L$0 = r10     // Catch:{ all -> 0x005a }
            r0.L$1 = r9     // Catch:{ all -> 0x005a }
            r0.L$2 = r8     // Catch:{ all -> 0x005a }
            r0.L$3 = r7     // Catch:{ all -> 0x005a }
            r0.L$4 = r6     // Catch:{ all -> 0x005a }
            r0.L$5 = r14     // Catch:{ all -> 0x005a }
            r0.label = r3     // Catch:{ all -> 0x005a }
            java.lang.Object r11 = r9.a(r0)     // Catch:{ all -> 0x005a }
            if (r11 != r1) goto L_0x00d6
            return r1
        L_0x00d6:
            r12 = r7
            r7 = r14
            r14 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r12
        L_0x00dd:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x0112 }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x0112 }
            if (r14 == 0) goto L_0x010a
            java.lang.Object r14 = r10.next()     // Catch:{ all -> 0x0112 }
            java.lang.Object r14 = r9.invoke(r7, r14)     // Catch:{ all -> 0x0112 }
            r0.L$0 = r11     // Catch:{ all -> 0x0112 }
            r0.L$1 = r10     // Catch:{ all -> 0x0112 }
            r0.L$2 = r9     // Catch:{ all -> 0x0112 }
            r0.L$3 = r8     // Catch:{ all -> 0x0112 }
            r0.L$4 = r6     // Catch:{ all -> 0x0112 }
            r0.L$5 = r5     // Catch:{ all -> 0x0112 }
            r0.label = r2     // Catch:{ all -> 0x0112 }
            java.lang.Object r14 = r11.send(r14, r0)     // Catch:{ all -> 0x0112 }
            if (r14 != r1) goto L_0x0102
            return r1
        L_0x0102:
            r7 = r9
            r9 = r11
        L_0x0104:
            r14 = r0
            r0 = r1
            r1 = r6
            r6 = r8
            r8 = r10
            goto L_0x0097
        L_0x010a:
            r14 = r0
            r0 = r1
            r1 = r6
            r6 = r8
            r7 = r9
            r8 = r10
            r9 = r11
            goto L_0x0097
        L_0x0112:
            r14 = move-exception
            r6 = r8
            goto L_0x011c
        L_0x0115:
            kotlin.Unit r14 = kotlin.Unit.f56620a     // Catch:{ all -> 0x005a }
            kotlinx.coroutines.channels.h.b(r7, r5)
            return r14
        L_0x011b:
            r14 = move-exception
        L_0x011c:
            throw r14     // Catch:{ all -> 0x011d }
        L_0x011d:
            r0 = move-exception
            kotlinx.coroutines.channels.h.b(r6, r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
