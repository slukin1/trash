package kotlinx.coroutines;

import java.util.Collection;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {66}, m = "joinAll")
public final class AwaitKt$joinAll$3 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public AwaitKt$joinAll$3(c<? super AwaitKt$joinAll$3> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.c((Collection<? extends n1>) null, this);
    }
}
