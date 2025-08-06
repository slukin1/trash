package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", l = {254, 255}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements p {
    public final /* synthetic */ int $n;
    public final /* synthetic */ ReceiveChannel $this_take;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$take$1(int i11, ReceiveChannel receiveChannel, c cVar) {
        super(2, cVar);
        this.$n = i11;
        this.$this_take = receiveChannel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, cVar);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    public final Object invoke(k kVar, c cVar) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            int r1 = r8.I$0
            java.lang.Object r4 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            kotlin.k.b(r9)
            r9 = r5
            r5 = r8
            goto L_0x0082
        L_0x001f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0027:
            int r1 = r8.I$0
            java.lang.Object r4 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            kotlin.k.b(r9)
            r6 = r8
            goto L_0x0065
        L_0x0036:
            kotlin.k.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.channels.k r9 = (kotlinx.coroutines.channels.k) r9
            int r1 = r8.$n
            if (r1 != 0) goto L_0x0044
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x0044:
            if (r1 < 0) goto L_0x0048
            r4 = r3
            goto L_0x0049
        L_0x0048:
            r4 = 0
        L_0x0049:
            if (r4 == 0) goto L_0x008c
            kotlinx.coroutines.channels.ReceiveChannel r4 = r8.$this_take
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r8
        L_0x0052:
            r5.L$0 = r9
            r5.L$1 = r4
            r5.I$0 = r1
            r5.label = r3
            java.lang.Object r6 = r4.a(r5)
            if (r6 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r7 = r5
            r5 = r9
            r9 = r6
            r6 = r7
        L_0x0065:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0089
            java.lang.Object r9 = r4.next()
            r6.L$0 = r5
            r6.L$1 = r4
            r6.I$0 = r1
            r6.label = r2
            java.lang.Object r9 = r5.send(r9, r6)
            if (r9 != r0) goto L_0x0080
            return r0
        L_0x0080:
            r9 = r5
            r5 = r6
        L_0x0082:
            int r1 = r1 + -1
            if (r1 != 0) goto L_0x0052
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x0089:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x008c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Requested element count "
            r9.append(r0)
            r9.append(r1)
            java.lang.String r0 = " is less than zero."
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
