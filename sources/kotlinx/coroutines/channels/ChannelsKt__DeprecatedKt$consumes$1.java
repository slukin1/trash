package kotlinx.coroutines.channels;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class ChannelsKt__DeprecatedKt$consumes$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ ReceiveChannel<?> $this_consumes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$consumes$1(ReceiveChannel<?> receiveChannel) {
        super(1);
        this.$this_consumes = receiveChannel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        h.b(this.$this_consumes, th2);
    }
}
