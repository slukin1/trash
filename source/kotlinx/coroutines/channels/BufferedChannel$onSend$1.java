package kotlinx.coroutines.channels;

import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.k;

public /* synthetic */ class BufferedChannel$onSend$1 extends FunctionReferenceImpl implements q<BufferedChannel<?>, k<?>, Object, Unit> {
    public static final BufferedChannel$onSend$1 INSTANCE = new BufferedChannel$onSend$1();

    public BufferedChannel$onSend$1() {
        super(3, BufferedChannel.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BufferedChannel<?>) (BufferedChannel) obj, (k<?>) (k) obj2, obj3);
        return Unit.f56620a;
    }

    public final void invoke(BufferedChannel<?> bufferedChannel, k<?> kVar, Object obj) {
        bufferedChannel.K0(kVar, obj);
    }
}
