package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SingleProcessDataStore$readData$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readData$1(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$readData$1> cVar) {
        super(cVar);
        this.this$0 = singleProcessDataStore;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.w(this);
    }
}
