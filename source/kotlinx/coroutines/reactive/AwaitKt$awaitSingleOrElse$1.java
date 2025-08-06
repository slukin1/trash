package kotlinx.coroutines.reactive;

import d10.a;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import z20.b;

@d(c = "kotlinx.coroutines.reactive.AwaitKt", f = "Await.kt", l = {170}, m = "awaitSingleOrElse")
public final class AwaitKt$awaitSingleOrElse$1<T> extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public AwaitKt$awaitSingleOrElse$1(c<? super AwaitKt$awaitSingleOrElse$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.f((b) null, (a) null, this);
    }
}
