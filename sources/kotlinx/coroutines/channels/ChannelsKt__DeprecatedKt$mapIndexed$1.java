package kotlinx.coroutines.channels;

import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", l = {344, 345, 345}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements p<k<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ ReceiveChannel<Object> $this_mapIndexed;
    public final /* synthetic */ q<Integer, Object, c<Object>, Object> $transform;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<Object> receiveChannel, q<? super Integer, Object, ? super c<Object>, ? extends Object> qVar, c<? super ChannelsKt__DeprecatedKt$mapIndexed$1> cVar) {
        super(2, cVar);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = qVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, cVar);
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    public final Object invoke(k<Object> kVar, c<? super Unit> cVar) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x004a
            if (r1 == r4) goto L_0x003b
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r11.I$0
            java.lang.Object r5 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.k r6 = (kotlinx.coroutines.channels.k) r6
            kotlin.k.b(r12)
            r12 = r6
            goto L_0x0058
        L_0x0020:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0028:
            int r1 = r11.I$0
            java.lang.Object r5 = r11.L$2
            kotlinx.coroutines.channels.k r5 = (kotlinx.coroutines.channels.k) r5
            java.lang.Object r6 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.k r7 = (kotlinx.coroutines.channels.k) r7
            kotlin.k.b(r12)
            r8 = r11
            goto L_0x0096
        L_0x003b:
            int r1 = r11.I$0
            java.lang.Object r5 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.k r6 = (kotlinx.coroutines.channels.k) r6
            kotlin.k.b(r12)
            r7 = r11
            goto L_0x006c
        L_0x004a:
            kotlin.k.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.k r12 = (kotlinx.coroutines.channels.k) r12
            r1 = 0
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r5 = r11.$this_mapIndexed
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
        L_0x0058:
            r6 = r11
        L_0x0059:
            r6.L$0 = r12
            r6.L$1 = r5
            r6.I$0 = r1
            r6.label = r4
            java.lang.Object r7 = r5.a(r6)
            if (r7 != r0) goto L_0x0068
            return r0
        L_0x0068:
            r10 = r6
            r6 = r12
            r12 = r7
            r7 = r10
        L_0x006c:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00ac
            java.lang.Object r12 = r5.next()
            d10.q<java.lang.Integer, java.lang.Object, kotlin.coroutines.c<java.lang.Object>, java.lang.Object> r8 = r7.$transform
            int r9 = r1 + 1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.a.c(r1)
            r7.L$0 = r6
            r7.L$1 = r5
            r7.L$2 = r6
            r7.I$0 = r9
            r7.label = r3
            java.lang.Object r12 = r8.invoke(r1, r12, r7)
            if (r12 != r0) goto L_0x0091
            return r0
        L_0x0091:
            r8 = r7
            r1 = r9
            r7 = r6
            r6 = r5
            r5 = r7
        L_0x0096:
            r8.L$0 = r7
            r8.L$1 = r6
            r9 = 0
            r8.L$2 = r9
            r8.I$0 = r1
            r8.label = r2
            java.lang.Object r12 = r5.send(r12, r8)
            if (r12 != r0) goto L_0x00a8
            return r0
        L_0x00a8:
            r5 = r6
            r12 = r7
            r6 = r8
            goto L_0x0059
        L_0x00ac:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
