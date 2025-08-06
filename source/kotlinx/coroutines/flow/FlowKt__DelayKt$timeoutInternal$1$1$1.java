package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.ChannelResult;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", l = {404}, m = "invokeSuspend")
public final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements p<ChannelResult<Object>, c<? super Boolean>, Object> {
    public final /* synthetic */ e<Object> $downStream;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$timeoutInternal$1$1$1(e<Object> eVar, c<? super FlowKt__DelayKt$timeoutInternal$1$1$1> cVar) {
        super(2, cVar);
        this.$downStream = eVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 flowKt__DelayKt$timeoutInternal$1$1$1 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, cVar);
        flowKt__DelayKt$timeoutInternal$1$1$1.L$0 = obj;
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m3084invokeWpGqRn0(((ChannelResult) obj).l(), (c) obj2);
    }

    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m3084invokeWpGqRn0(Object obj, c<? super Boolean> cVar) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(ChannelResult.b(obj), cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0019
            if (r1 != r2) goto L_0x0011
            java.lang.Object r0 = r4.L$0
            kotlin.k.b(r5)
            goto L_0x0036
        L_0x0011:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0019:
            kotlin.k.b(r5)
            java.lang.Object r5 = r4.L$0
            kotlinx.coroutines.channels.ChannelResult r5 = (kotlinx.coroutines.channels.ChannelResult) r5
            java.lang.Object r5 = r5.l()
            kotlinx.coroutines.flow.e<java.lang.Object> r1 = r4.$downStream
            boolean r3 = r5 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
            if (r3 != 0) goto L_0x0037
            r4.L$0 = r5
            r4.label = r2
            java.lang.Object r1 = r1.emit(r5, r4)
            if (r1 != r0) goto L_0x0035
            return r0
        L_0x0035:
            r0 = r5
        L_0x0036:
            r5 = r0
        L_0x0037:
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.ChannelResult.a
            if (r0 == 0) goto L_0x0045
            kotlinx.coroutines.channels.ChannelResult.e(r5)
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)
            return r5
        L_0x0045:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
