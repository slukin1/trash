package kotlinx.coroutines.flow;

import d10.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class FlowKt__DistinctKt$defaultAreEquivalent$1 extends Lambda implements p<Object, Object, Boolean> {
    public static final FlowKt__DistinctKt$defaultAreEquivalent$1 INSTANCE = new FlowKt__DistinctKt$defaultAreEquivalent$1();

    public FlowKt__DistinctKt$defaultAreEquivalent$1() {
        super(2);
    }

    public final Boolean invoke(Object obj, Object obj2) {
        return Boolean.valueOf(x.b(obj, obj2));
    }
}
