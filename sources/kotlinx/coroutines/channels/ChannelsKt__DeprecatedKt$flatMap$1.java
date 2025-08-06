package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", l = {321, 322, 322}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements p {
    public final /* synthetic */ ReceiveChannel $this_flatMap;
    public final /* synthetic */ p $transform;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$flatMap$1(ReceiveChannel receiveChannel, p pVar, c cVar) {
        super(2, cVar);
        this.$this_flatMap = receiveChannel;
        this.$transform = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1 = new ChannelsKt__DeprecatedKt$flatMap$1(this.$this_flatMap, this.$transform, cVar);
        channelsKt__DeprecatedKt$flatMap$1.L$0 = obj;
        return channelsKt__DeprecatedKt$flatMap$1;
    }

    public final Object invoke(k kVar, c cVar) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0045
            if (r1 == r4) goto L_0x0035
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            kotlin.k.b(r10)
            goto L_0x0053
        L_0x001d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0025:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            kotlin.k.b(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x0082
        L_0x0035:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            kotlin.k.b(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x0067
        L_0x0045:
            kotlin.k.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.channels.k r10 = (kotlinx.coroutines.channels.k) r10
            kotlinx.coroutines.channels.ReceiveChannel r1 = r9.$this_flatMap
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r10
        L_0x0053:
            r10 = r9
        L_0x0054:
            r10.L$0 = r5
            r10.L$1 = r1
            r10.label = r4
            java.lang.Object r6 = r1.a(r10)
            if (r6 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r8 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L_0x0067:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0096
            java.lang.Object r10 = r5.next()
            d10.p r7 = r0.$transform
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r10 = r7.invoke(r10, r0)
            if (r10 != r1) goto L_0x0082
            return r1
        L_0x0082:
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r2
            java.lang.Object r10 = kotlinx.coroutines.channels.h.s(r10, r6, r0)
            if (r10 != r1) goto L_0x0091
            return r1
        L_0x0091:
            r10 = r0
            r0 = r1
            r1 = r5
            r5 = r6
            goto L_0x0054
        L_0x0096:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
