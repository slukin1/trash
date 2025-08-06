package kotlinx.coroutines.channels;

import d10.p;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class BufferedChannelKt$createSegmentFunction$1 extends FunctionReferenceImpl implements p<Long, g<E>, g<E>> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = new BufferedChannelKt$createSegmentFunction$1();

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), (g) obj2);
    }

    public final g<E> invoke(long j11, g<E> gVar) {
        return BufferedChannelKt.x(j11, gVar);
    }
}
