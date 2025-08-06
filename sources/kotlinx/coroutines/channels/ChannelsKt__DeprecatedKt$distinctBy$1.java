package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", l = {387, 388, 390}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements p<k<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ p<Object, c<Object>, Object> $selector;
    public final /* synthetic */ ReceiveChannel<Object> $this_distinctBy;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<Object> receiveChannel, p<Object, ? super c<Object>, ? extends Object> pVar, c<? super ChannelsKt__DeprecatedKt$distinctBy$1> cVar) {
        super(2, cVar);
        this.$this_distinctBy = receiveChannel;
        this.$selector = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, cVar);
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    public final Object invoke(k<Object> kVar, c<? super Unit> cVar) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x005a
            if (r1 == r4) goto L_0x0045
            if (r1 == r3) goto L_0x002d
            if (r1 != r2) goto L_0x0025
            java.lang.Object r1 = r11.L$3
            java.lang.Object r5 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r11.L$1
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.k r7 = (kotlinx.coroutines.channels.k) r7
            kotlin.k.b(r12)
            r12 = r11
            goto L_0x00cb
        L_0x0025:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x002d:
            java.lang.Object r1 = r11.L$3
            java.lang.Object r5 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r11.L$1
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.channels.k r7 = (kotlinx.coroutines.channels.k) r7
            kotlin.k.b(r12)
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r11
            goto L_0x00ae
        L_0x0045:
            java.lang.Object r1 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r11.L$1
            java.util.HashSet r5 = (java.util.HashSet) r5
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.channels.k r6 = (kotlinx.coroutines.channels.k) r6
            kotlin.k.b(r12)
            r7 = r6
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r11
            goto L_0x008a
        L_0x005a:
            kotlin.k.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.channels.k r12 = (kotlinx.coroutines.channels.k) r12
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r5 = r11.$this_distinctBy
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r12
            r12 = r11
            r10 = r5
            r5 = r1
            r1 = r10
        L_0x0071:
            r12.L$0 = r6
            r12.L$1 = r5
            r12.L$2 = r1
            r7 = 0
            r12.L$3 = r7
            r12.label = r4
            java.lang.Object r7 = r1.a(r12)
            if (r7 != r0) goto L_0x0083
            return r0
        L_0x0083:
            r10 = r0
            r0 = r12
            r12 = r7
            r7 = r6
            r6 = r5
            r5 = r1
            r1 = r10
        L_0x008a:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00d8
            java.lang.Object r12 = r5.next()
            d10.p<java.lang.Object, kotlin.coroutines.c<java.lang.Object>, java.lang.Object> r8 = r0.$selector
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r5
            r0.L$3 = r12
            r0.label = r3
            java.lang.Object r8 = r8.invoke(r12, r0)
            if (r8 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r10 = r6
            r6 = r12
            r12 = r8
            r8 = r7
            r7 = r10
        L_0x00ae:
            boolean r9 = r7.contains(r12)
            if (r9 != 0) goto L_0x00d2
            r0.L$0 = r8
            r0.L$1 = r7
            r0.L$2 = r5
            r0.L$3 = r12
            r0.label = r2
            java.lang.Object r6 = r8.send(r6, r0)
            if (r6 != r1) goto L_0x00c5
            return r1
        L_0x00c5:
            r6 = r7
            r7 = r8
            r10 = r1
            r1 = r12
            r12 = r0
            r0 = r10
        L_0x00cb:
            r6.add(r1)
            r1 = r5
            r5 = r6
            r6 = r7
            goto L_0x0071
        L_0x00d2:
            r12 = r0
            r0 = r1
            r1 = r5
            r5 = r7
            r6 = r8
            goto L_0x0071
        L_0x00d8:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
