package kotlinx.coroutines.sync;

import d10.a;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", l = {125}, m = "withLock")
public final class MutexKt$withLock$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public MutexKt$withLock$1(c<? super MutexKt$withLock$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MutexKt.e((a) null, (Object) null, (a) null, this);
    }
}
