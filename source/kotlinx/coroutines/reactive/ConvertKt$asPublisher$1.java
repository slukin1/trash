package kotlinx.coroutines.reactive;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.k;

@d(c = "kotlinx.coroutines.reactive.ConvertKt$asPublisher$1", f = "Convert.kt", l = {16, 17}, m = "invokeSuspend")
final class ConvertKt$asPublisher$1 extends SuspendLambda implements p {
    public final /* synthetic */ ReceiveChannel $this_asPublisher;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConvertKt$asPublisher$1(ReceiveChannel receiveChannel, c cVar) {
        super(2, cVar);
        this.$this_asPublisher = receiveChannel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ConvertKt$asPublisher$1 convertKt$asPublisher$1 = new ConvertKt$asPublisher$1(this.$this_asPublisher, cVar);
        convertKt$asPublisher$1.L$0 = obj;
        return convertKt$asPublisher$1;
    }

    public final Object invoke(k kVar, c cVar) {
        return ((ConvertKt$asPublisher$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0030
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.channels.k r4 = (kotlinx.coroutines.channels.k) r4
            kotlin.k.b(r8)
            r8 = r4
            goto L_0x003d
        L_0x001b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0023:
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.channels.k r4 = (kotlinx.coroutines.channels.k) r4
            kotlin.k.b(r8)
            r5 = r7
            goto L_0x004f
        L_0x0030:
            kotlin.k.b(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.channels.k r8 = (kotlinx.coroutines.channels.k) r8
            kotlinx.coroutines.channels.ReceiveChannel r1 = r7.$this_asPublisher
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
        L_0x003d:
            r4 = r7
        L_0x003e:
            r4.L$0 = r8
            r4.L$1 = r1
            r4.label = r3
            java.lang.Object r5 = r1.a(r4)
            if (r5 != r0) goto L_0x004b
            return r0
        L_0x004b:
            r6 = r4
            r4 = r8
            r8 = r5
            r5 = r6
        L_0x004f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x006b
            java.lang.Object r8 = r1.next()
            r5.L$0 = r4
            r5.L$1 = r1
            r5.label = r2
            java.lang.Object r8 = r4.send(r8, r5)
            if (r8 != r0) goto L_0x0068
            return r0
        L_0x0068:
            r8 = r4
            r4 = r5
            goto L_0x003e
        L_0x006b:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.ConvertKt$asPublisher$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
