package kotlinx.coroutines.channels;

import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", l = {211, 212, 212}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements p {
    public final /* synthetic */ q $predicate;
    public final /* synthetic */ ReceiveChannel $this_filterIndexed;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel receiveChannel, q qVar, c cVar) {
        super(2, cVar);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = qVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, cVar);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    public final Object invoke(k kVar, c cVar) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082  */
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
            if (r1 == 0) goto L_0x0052
            if (r1 == r5) goto L_0x003f
            if (r1 == r4) goto L_0x0028
            if (r1 != r3) goto L_0x0020
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.k r7 = (kotlinx.coroutines.channels.k) r7
            kotlin.k.b(r13)
            goto L_0x0061
        L_0x0020:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0028:
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$2
            java.lang.Object r7 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.k r8 = (kotlinx.coroutines.channels.k) r8
            kotlin.k.b(r13)
            r10 = r1
            r1 = r0
            r0 = r12
            r11 = r7
            r7 = r6
        L_0x003c:
            r6 = r11
            goto L_0x00a3
        L_0x003f:
            int r1 = r12.I$0
            java.lang.Object r6 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.channels.k r7 = (kotlinx.coroutines.channels.k) r7
            kotlin.k.b(r13)
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r12
            goto L_0x007a
        L_0x0052:
            kotlin.k.b(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.channels.k r13 = (kotlinx.coroutines.channels.k) r13
            r1 = 0
            kotlinx.coroutines.channels.ReceiveChannel r6 = r12.$this_filterIndexed
            kotlinx.coroutines.channels.ChannelIterator r6 = r6.iterator()
            r7 = r13
        L_0x0061:
            r13 = r12
        L_0x0062:
            r13.L$0 = r7
            r13.L$1 = r6
            r13.L$2 = r2
            r13.I$0 = r1
            r13.label = r5
            java.lang.Object r8 = r6.a(r13)
            if (r8 != r0) goto L_0x0073
            return r0
        L_0x0073:
            r11 = r0
            r0 = r13
            r13 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r11
        L_0x007a:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00c1
            java.lang.Object r13 = r7.next()
            d10.q r9 = r0.$predicate
            int r10 = r6 + 1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.a.c(r6)
            r0.L$0 = r8
            r0.L$1 = r7
            r0.L$2 = r13
            r0.I$0 = r10
            r0.label = r4
            java.lang.Object r6 = r9.invoke(r6, r13, r0)
            if (r6 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r11 = r7
            r7 = r13
            r13 = r6
            goto L_0x003c
        L_0x00a3:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00bc
            r0.L$0 = r8
            r0.L$1 = r6
            r0.L$2 = r2
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r13 = r8.send(r7, r0)
            if (r13 != r1) goto L_0x00bc
            return r1
        L_0x00bc:
            r13 = r0
            r0 = r1
            r7 = r8
            r1 = r10
            goto L_0x0062
        L_0x00c1:
            kotlin.Unit r13 = kotlin.Unit.f56620a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
