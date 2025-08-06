package kotlinx.coroutines.channels;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class ChannelsKt__DeprecatedKt$consumesAll$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ ReceiveChannel<?>[] $channels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$consumesAll$1(ReceiveChannel<?>[] receiveChannelArr) {
        super(1);
        this.$channels = receiveChannelArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        Throwable th3 = null;
        for (ReceiveChannel<?> b11 : this.$channels) {
            try {
                h.b(b11, th2);
            } catch (Throwable th4) {
                if (th3 == null) {
                    th3 = th4;
                } else {
                    ExceptionsKt__ExceptionsKt.a(th3, th4);
                }
            }
        }
        if (th3 != null) {
            throw th3;
        }
    }
}
