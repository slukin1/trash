package kotlinx.coroutines.flow;

import d10.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class FlowKt__ZipKt$combine$6$1 extends Lambda implements a<Object[]> {
    public final /* synthetic */ d<Object>[] $flowArray;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$6$1(d<Object>[] dVarArr) {
        super(0);
        this.$flowArray = dVarArr;
    }

    public final Object[] invoke() {
        int length = this.$flowArray.length;
        x.f(0, "T?");
        return new Object[length];
    }
}
