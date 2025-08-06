package kotlinx.coroutines.rx3;

import d10.l;
import io.reactivex.rxjava3.disposables.b;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.x;

public /* synthetic */ class RxSchedulerKt$scheduleTask$toSchedule$1 extends FunctionReferenceImpl implements l<c<? super Unit>, Object> {
    public final /* synthetic */ CoroutineContext $ctx;
    public final /* synthetic */ Runnable $decoratedBlock;
    public final /* synthetic */ b $disposable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxSchedulerKt$scheduleTask$toSchedule$1(b bVar, CoroutineContext coroutineContext, Runnable runnable) {
        super(1, x.a.class, "task", "scheduleTask$task(Lio/reactivex/rxjava3/disposables/Disposable;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        this.$disposable = bVar;
        this.$ctx = coroutineContext;
        this.$decoratedBlock = runnable;
    }

    public final Object invoke(c<? super Unit> cVar) {
        return RxSchedulerKt.g(this.$disposable, this.$ctx, this.$decoratedBlock, cVar);
    }
}
