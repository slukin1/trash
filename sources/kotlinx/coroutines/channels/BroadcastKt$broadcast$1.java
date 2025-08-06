package kotlinx.coroutines.channels;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class BroadcastKt$broadcast$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ ReceiveChannel<Object> $this_broadcast;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastKt$broadcast$1(ReceiveChannel<Object> receiveChannel) {
        super(1);
        this.$this_broadcast = receiveChannel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        h.b(this.$this_broadcast, th2);
    }
}
