package kotlinx.coroutines.rx3;

import h00.g;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.rx3.RxAwaitKt", f = "RxAwait.kt", l = {109}, m = "awaitOrDefault")
public final class RxAwaitKt$awaitOrDefault$1<T> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public RxAwaitKt$awaitOrDefault$1(c<? super RxAwaitKt$awaitOrDefault$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxAwaitKt.e((g) null, (Object) null, this);
    }
}
