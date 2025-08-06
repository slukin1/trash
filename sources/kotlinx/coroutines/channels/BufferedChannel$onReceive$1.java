package kotlinx.coroutines.channels;

import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.k;

public /* synthetic */ class BufferedChannel$onReceive$1 extends FunctionReferenceImpl implements q<BufferedChannel<?>, k<?>, Object, Unit> {
    public static final BufferedChannel$onReceive$1 INSTANCE = new BufferedChannel$onReceive$1();

    public BufferedChannel$onReceive$1() {
        super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BufferedChannel<?>) (BufferedChannel) obj, (k<?>) (k) obj2, obj3);
        return Unit.f56620a;
    }

    public final void invoke(BufferedChannel<?> bufferedChannel, k<?> kVar, Object obj) {
        bufferedChannel.J0(kVar, obj);
    }
}
