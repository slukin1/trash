package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.disposables.b;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.rx3.RxSchedulerKt", f = "RxScheduler.kt", l = {126}, m = "scheduleTask$task")
public final class RxSchedulerKt$scheduleTask$task$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public RxSchedulerKt$scheduleTask$task$1(c<? super RxSchedulerKt$scheduleTask$task$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxSchedulerKt.g((b) null, (CoroutineContext) null, (Runnable) null, this);
    }
}
