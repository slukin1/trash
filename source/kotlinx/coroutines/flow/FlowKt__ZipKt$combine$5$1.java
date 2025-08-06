package kotlinx.coroutines.flow;

import d10.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class FlowKt__ZipKt$combine$5$1 extends Lambda implements a<Object[]> {
    public final /* synthetic */ d<Object>[] $flows;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$5$1(d<Object>[] dVarArr) {
        super(0);
        this.$flows = dVarArr;
    }

    public final Object[] invoke() {
        int length = this.$flows.length;
        x.f(0, "T?");
        return new Object[length];
    }
}
