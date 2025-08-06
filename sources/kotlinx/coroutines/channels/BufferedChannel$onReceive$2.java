package kotlinx.coroutines.channels;

import d10.q;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class BufferedChannel$onReceive$2 extends FunctionReferenceImpl implements q<BufferedChannel<?>, Object, Object, Object> {
    public static final BufferedChannel$onReceive$2 INSTANCE = new BufferedChannel$onReceive$2();

    public BufferedChannel$onReceive$2() {
        super(3, BufferedChannel.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(BufferedChannel<?> bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.B0(obj, obj2);
    }
}
