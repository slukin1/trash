package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", l = {164, 169, 170}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$drop$1 extends SuspendLambda implements p {
    public final /* synthetic */ int $n;
    public final /* synthetic */ ReceiveChannel $this_drop;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$drop$1(int i11, ReceiveChannel receiveChannel, c cVar) {
        super(2, cVar);
        this.$n = i11;
        this.$this_drop = receiveChannel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1 = new ChannelsKt__DeprecatedKt$drop$1(this.$n, this.$this_drop, cVar);
        channelsKt__DeprecatedKt$drop$1.L$0 = obj;
        return channelsKt__DeprecatedKt$drop$1;
    }

    public final Object invoke(k kVar, c cVar) {
        return ((ChannelsKt__DeprecatedKt$drop$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x004e
            if (r1 == r4) goto L_0x003b
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.channels.k r4 = (kotlinx.coroutines.channels.k) r4
            kotlin.k.b(r10)
            r10 = r4
            r4 = r1
            r1 = r0
            r0 = r9
            goto L_0x009f
        L_0x0022:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x002a:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.channels.k r4 = (kotlinx.coroutines.channels.k) r4
            kotlin.k.b(r10)
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r9
            goto L_0x00af
        L_0x003b:
            int r1 = r9.I$0
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
            goto L_0x007e
        L_0x004e:
            kotlin.k.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.channels.k r10 = (kotlinx.coroutines.channels.k) r10
            int r1 = r9.$n
            if (r1 < 0) goto L_0x005b
            r5 = r4
            goto L_0x005c
        L_0x005b:
            r5 = 0
        L_0x005c:
            if (r5 == 0) goto L_0x00cd
            if (r1 <= 0) goto L_0x0097
            kotlinx.coroutines.channels.ReceiveChannel r5 = r9.$this_drop
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r10
            r10 = r9
        L_0x0068:
            r10.L$0 = r6
            r10.L$1 = r5
            r10.I$0 = r1
            r10.label = r4
            java.lang.Object r7 = r5.a(r10)
            if (r7 != r0) goto L_0x0077
            return r0
        L_0x0077:
            r8 = r0
            r0 = r10
            r10 = r7
            r7 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L_0x007e:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0095
            r6.next()
            int r10 = r5 + -1
            if (r10 != 0) goto L_0x008e
            goto L_0x0095
        L_0x008e:
            r5 = r6
            r6 = r7
            r8 = r1
            r1 = r10
            r10 = r0
            r0 = r8
            goto L_0x0068
        L_0x0095:
            r10 = r7
            goto L_0x0099
        L_0x0097:
            r1 = r0
            r0 = r9
        L_0x0099:
            kotlinx.coroutines.channels.ReceiveChannel r4 = r0.$this_drop
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
        L_0x009f:
            r0.L$0 = r10
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r5 = r4.a(r0)
            if (r5 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            r8 = r5
            r5 = r10
            r10 = r8
        L_0x00af:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00ca
            java.lang.Object r10 = r4.next()
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r2
            java.lang.Object r10 = r5.send(r10, r0)
            if (r10 != r1) goto L_0x00c8
            return r1
        L_0x00c8:
            r10 = r5
            goto L_0x009f
        L_0x00ca:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        L_0x00cd:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Requested element count "
            r10.append(r0)
            r10.append(r1)
            java.lang.String r0 = " is less than zero."
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
