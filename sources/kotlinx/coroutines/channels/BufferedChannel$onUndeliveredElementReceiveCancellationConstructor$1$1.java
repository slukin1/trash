package kotlinx.coroutines.channels;

import d10.l;
import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.selects.k;

public final class BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1 extends Lambda implements q<k<?>, Object, Object, l<? super Throwable, ? extends Unit>> {
    public final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(BufferedChannel<E> bufferedChannel) {
        super(3);
        this.this$0 = bufferedChannel;
    }

    public final l<Throwable, Unit> invoke(final k<?> kVar, Object obj, final Object obj2) {
        final BufferedChannel<E> bufferedChannel = this.this$0;
        return new l<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f56620a;
            }

            public final void invoke(Throwable th2) {
                if (obj2 != BufferedChannelKt.z()) {
                    OnUndeliveredElementKt.b(bufferedChannel.f57011c, obj2, kVar.getContext());
                }
            }
        };
    }
}
