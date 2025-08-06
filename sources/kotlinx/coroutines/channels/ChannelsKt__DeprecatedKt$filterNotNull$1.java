package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", l = {}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$filterNotNull$1 extends SuspendLambda implements p<Object, c<? super Boolean>, Object> {
    public /* synthetic */ Object L$0;
    public int label;

    public ChannelsKt__DeprecatedKt$filterNotNull$1(c<? super ChannelsKt__DeprecatedKt$filterNotNull$1> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__DeprecatedKt$filterNotNull$1 channelsKt__DeprecatedKt$filterNotNull$1 = new ChannelsKt__DeprecatedKt$filterNotNull$1(cVar);
        channelsKt__DeprecatedKt$filterNotNull$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterNotNull$1;
    }

    public final Object invoke(Object obj, c<? super Boolean> cVar) {
        return ((ChannelsKt__DeprecatedKt$filterNotNull$1) create(obj, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            return a.a(this.L$0 != null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
