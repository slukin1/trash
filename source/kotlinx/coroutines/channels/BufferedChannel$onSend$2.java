package kotlinx.coroutines.channels;

import d10.q;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class BufferedChannel$onSend$2 extends FunctionReferenceImpl implements q<BufferedChannel<?>, Object, Object, Object> {
    public static final BufferedChannel$onSend$2 INSTANCE = new BufferedChannel$onSend$2();

    public BufferedChannel$onSend$2() {
        super(3, BufferedChannel.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(BufferedChannel<?> bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.E0(obj, obj2);
    }
}
