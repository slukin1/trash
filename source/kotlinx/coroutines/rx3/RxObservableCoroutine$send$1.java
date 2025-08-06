package kotlinx.coroutines.rx3;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.rx3.RxObservableCoroutine", f = "RxObservable.kt", l = {117}, m = "send")
public final class RxObservableCoroutine$send$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ RxObservableCoroutine<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxObservableCoroutine$send$1(RxObservableCoroutine<T> rxObservableCoroutine, c<? super RxObservableCoroutine$send$1> cVar) {
        super(cVar);
        this.this$0 = rxObservableCoroutine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send(null, this);
    }
}
