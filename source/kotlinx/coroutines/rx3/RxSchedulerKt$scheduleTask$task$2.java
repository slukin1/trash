package kotlinx.coroutines.rx3;

import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class RxSchedulerKt$scheduleTask$task$2 extends Lambda implements a<Unit> {
    public final /* synthetic */ Runnable $decoratedBlock;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxSchedulerKt$scheduleTask$task$2(Runnable runnable) {
        super(0);
        this.$decoratedBlock = runnable;
    }

    public final void invoke() {
        this.$decoratedBlock.run();
    }
}
