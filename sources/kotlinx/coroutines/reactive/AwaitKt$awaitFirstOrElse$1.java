package kotlinx.coroutines.reactive;

import d10.a;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import z20.b;

@d(c = "kotlinx.coroutines.reactive.AwaitKt", f = "Await.kt", l = {56}, m = "awaitFirstOrElse")
public final class AwaitKt$awaitFirstOrElse$1<T> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public AwaitKt$awaitFirstOrElse$1(c<? super AwaitKt$awaitFirstOrElse$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.c((b) null, (a) null, this);
    }
}
