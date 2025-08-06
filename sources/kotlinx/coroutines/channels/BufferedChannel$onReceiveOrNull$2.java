package kotlinx.coroutines.channels;

import d10.q;
import kotlin.jvm.internal.FunctionReferenceImpl;

final /* synthetic */ class BufferedChannel$onReceiveOrNull$2 extends FunctionReferenceImpl implements q<BufferedChannel<?>, Object, Object, Object> {
    public static final BufferedChannel$onReceiveOrNull$2 INSTANCE = new BufferedChannel$onReceiveOrNull$2();

    public BufferedChannel$onReceiveOrNull$2() {
        super(3, BufferedChannel.class, "processResultSelectReceiveOrNull", "processResultSelectReceiveOrNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(BufferedChannel<?> bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.D0(obj, obj2);
    }
}
