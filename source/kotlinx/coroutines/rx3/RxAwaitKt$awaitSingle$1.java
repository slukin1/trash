package kotlinx.coroutines.rx3;

import h00.g;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.rx3.RxAwaitKt", f = "RxAwait.kt", l = {63}, m = "awaitSingle")
public final class RxAwaitKt$awaitSingle$1<T> extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    public RxAwaitKt$awaitSingle$1(c<? super RxAwaitKt$awaitSingle$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxAwaitKt.f((g) null, this);
    }
}
