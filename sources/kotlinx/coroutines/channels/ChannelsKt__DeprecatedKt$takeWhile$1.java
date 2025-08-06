package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", l = {269, 270, 271}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$takeWhile$1 extends SuspendLambda implements p {
    public final /* synthetic */ p $predicate;
    public final /* synthetic */ ReceiveChannel $this_takeWhile;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$takeWhile$1(ReceiveChannel receiveChannel, p pVar, c cVar) {
        super(2, cVar);
        this.$this_takeWhile = receiveChannel;
        this.$predicate = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, cVar);
        channelsKt__DeprecatedKt$takeWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$takeWhile$1;
    }

    public final Object invoke(k kVar, c cVar) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0048
            if (r1 == r4) goto L_0x0038
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            kotlin.k.b(r10)
            goto L_0x0056
        L_0x001d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0025:
            java.lang.Object r1 = r9.L$2
            java.lang.Object r5 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.channels.k r6 = (kotlinx.coroutines.channels.k) r6
            kotlin.k.b(r10)
            r7 = r6
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x008c
        L_0x0038:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            kotlin.k.b(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L_0x006a
        L_0x0048:
            kotlin.k.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.channels.k r10 = (kotlinx.coroutines.channels.k) r10
            kotlinx.coroutines.channels.ReceiveChannel r1 = r9.$this_takeWhile
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r10
        L_0x0056:
            r10 = r9
        L_0x0057:
            r10.L$0 = r5
            r10.L$1 = r1
            r10.label = r4
            java.lang.Object r6 = r1.a(r10)
            if (r6 != r0) goto L_0x0064
            return r0
        L_0x0064:
            r8 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L_0x006a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00ac
            java.lang.Object r10 = r5.next()
            d10.p r7 = r0.$predicate
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r7 = r7.invoke(r10, r0)
            if (r7 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r8 = r5
            r5 = r10
            r10 = r7
            r7 = r6
            r6 = r8
        L_0x008c:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x0097
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        L_0x0097:
            r0.L$0 = r7
            r0.L$1 = r6
            r10 = 0
            r0.L$2 = r10
            r0.label = r2
            java.lang.Object r10 = r7.send(r5, r0)
            if (r10 != r1) goto L_0x00a7
            return r1
        L_0x00a7:
            r10 = r0
            r0 = r1
            r1 = r6
            r5 = r7
            goto L_0x0057
        L_0x00ac:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
