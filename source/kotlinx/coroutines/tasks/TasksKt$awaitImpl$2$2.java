package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class TasksKt$awaitImpl$2$2 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ CancellationTokenSource $cancellationTokenSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TasksKt$awaitImpl$2$2(CancellationTokenSource cancellationTokenSource) {
        super(1);
        this.$cancellationTokenSource = cancellationTokenSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.$cancellationTokenSource.cancel();
    }
}
