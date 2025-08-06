package kotlinx.coroutines.android;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HandlerContext$scheduleResumeAfterDelay$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ Runnable $block;
    public final /* synthetic */ HandlerContext this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandlerContext$scheduleResumeAfterDelay$1(HandlerContext handlerContext, Runnable runnable) {
        super(1);
        this.this$0 = handlerContext;
        this.$block = runnable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.this$0.f56979c.removeCallbacks(this.$block);
    }
}
