package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", l = {181, 182, 183, 187, 188}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements p {
    public final /* synthetic */ p $predicate;
    public final /* synthetic */ ReceiveChannel $this_dropWhile;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel receiveChannel, p pVar, c cVar) {
        super(2, cVar);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, cVar);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    public final Object invoke(k kVar, c cVar) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r12.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0070
            if (r1 == r6) goto L_0x0060
            if (r1 == r5) goto L_0x004e
            if (r1 == r4) goto L_0x0042
            if (r1 == r3) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            java.lang.Object r1 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.channels.k r4 = (kotlinx.coroutines.channels.k) r4
            kotlin.k.b(r13)
            r13 = r1
            r9 = r4
            r1 = r0
            r0 = r12
            goto L_0x00d9
        L_0x0029:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0031:
            java.lang.Object r1 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.channels.k r4 = (kotlinx.coroutines.channels.k) r4
            kotlin.k.b(r13)
            r9 = r4
            r4 = r1
            r1 = r0
            r0 = r12
            goto L_0x00e9
        L_0x0042:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.channels.k r1 = (kotlinx.coroutines.channels.k) r1
            kotlin.k.b(r13)
            r10 = r1
            r1 = r0
            r0 = r12
            goto L_0x00cc
        L_0x004e:
            java.lang.Object r1 = r12.L$2
            java.lang.Object r8 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r12.L$0
            kotlinx.coroutines.channels.k r9 = (kotlinx.coroutines.channels.k) r9
            kotlin.k.b(r13)
            r10 = r9
            r9 = r1
            r1 = r0
            r0 = r12
            goto L_0x00b5
        L_0x0060:
            java.lang.Object r1 = r12.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r8 = r12.L$0
            kotlinx.coroutines.channels.k r8 = (kotlinx.coroutines.channels.k) r8
            kotlin.k.b(r13)
            r9 = r8
            r8 = r1
            r1 = r0
            r0 = r12
            goto L_0x0094
        L_0x0070:
            kotlin.k.b(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.channels.k r13 = (kotlinx.coroutines.channels.k) r13
            kotlinx.coroutines.channels.ReceiveChannel r1 = r12.$this_dropWhile
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r8 = r13
            r13 = r12
        L_0x007f:
            r13.L$0 = r8
            r13.L$1 = r1
            r13.L$2 = r7
            r13.label = r6
            java.lang.Object r9 = r1.a(r13)
            if (r9 != r0) goto L_0x008e
            return r0
        L_0x008e:
            r11 = r0
            r0 = r13
            r13 = r9
            r9 = r8
            r8 = r1
            r1 = r11
        L_0x0094:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00d3
            java.lang.Object r13 = r8.next()
            d10.p r10 = r0.$predicate
            r0.L$0 = r9
            r0.L$1 = r8
            r0.L$2 = r13
            r0.label = r5
            java.lang.Object r10 = r10.invoke(r13, r0)
            if (r10 != r1) goto L_0x00b1
            return r1
        L_0x00b1:
            r11 = r9
            r9 = r13
            r13 = r10
            r10 = r11
        L_0x00b5:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x00ce
            r0.L$0 = r10
            r0.L$1 = r7
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r13 = r10.send(r9, r0)
            if (r13 != r1) goto L_0x00cc
            return r1
        L_0x00cc:
            r9 = r10
            goto L_0x00d3
        L_0x00ce:
            r13 = r0
            r0 = r1
            r1 = r8
            r8 = r10
            goto L_0x007f
        L_0x00d3:
            kotlinx.coroutines.channels.ReceiveChannel r13 = r0.$this_dropWhile
            kotlinx.coroutines.channels.ChannelIterator r13 = r13.iterator()
        L_0x00d9:
            r0.L$0 = r9
            r0.L$1 = r13
            r0.label = r3
            java.lang.Object r4 = r13.a(r0)
            if (r4 != r1) goto L_0x00e6
            return r1
        L_0x00e6:
            r11 = r4
            r4 = r13
            r13 = r11
        L_0x00e9:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x0104
            java.lang.Object r13 = r4.next()
            r0.L$0 = r9
            r0.L$1 = r4
            r0.label = r2
            java.lang.Object r13 = r9.send(r13, r0)
            if (r13 != r1) goto L_0x0102
            return r1
        L_0x0102:
            r13 = r4
            goto L_0x00d9
        L_0x0104:
            kotlin.Unit r13 = kotlin.Unit.f56620a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
