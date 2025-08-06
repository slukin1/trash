package kotlinx.coroutines.channels;

import d10.q;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class BufferedChannel$onReceiveCatching$2 extends FunctionReferenceImpl implements q<BufferedChannel<?>, Object, Object, Object> {
    public static final BufferedChannel$onReceiveCatching$2 INSTANCE = new BufferedChannel$onReceiveCatching$2();

    public BufferedChannel$onReceiveCatching$2() {
        super(3, BufferedChannel.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(BufferedChannel<?> bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.C0(obj, obj2);
    }
}
