package androidx.lifecycle;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {235}, m = "clearSource$lifecycle_livedata_release")
final class CoroutineLiveData$clearSource$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ h<Object> this$0;

    public CoroutineLiveData$clearSource$1(h<Object> hVar, c<? super CoroutineLiveData$clearSource$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
