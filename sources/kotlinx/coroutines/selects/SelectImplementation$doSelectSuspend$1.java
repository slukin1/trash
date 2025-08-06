package kotlinx.coroutines.selects;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", l = {431, 434}, m = "doSelectSuspend")
public final class SelectImplementation$doSelectSuspend$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SelectImplementation<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectImplementation$doSelectSuspend$1(SelectImplementation<R> selectImplementation, c<? super SelectImplementation$doSelectSuspend$1> cVar) {
        super(cVar);
        this.this$0 = selectImplementation;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.t(this);
    }
}
