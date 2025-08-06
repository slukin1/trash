package kotlinx.coroutines.rx3;

import d10.a;
import h00.j;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.rx3.RxAwaitKt", f = "RxAwait.kt", l = {178}, m = "awaitFirstOrElse")
public final class RxAwaitKt$awaitFirstOrElse$1<T> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public RxAwaitKt$awaitFirstOrElse$1(c<? super RxAwaitKt$awaitFirstOrElse$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxAwaitKt.b((j) null, (a) null, this);
    }
}
