package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import d10.l;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.n0;

final class TasksKt$asTask$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ CancellationTokenSource $cancellation;
    public final /* synthetic */ TaskCompletionSource<Object> $source;
    public final /* synthetic */ n0<Object> $this_asTask;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TasksKt$asTask$1(CancellationTokenSource cancellationTokenSource, n0<Object> n0Var, TaskCompletionSource<Object> taskCompletionSource) {
        super(1);
        this.$cancellation = cancellationTokenSource;
        this.$this_asTask = n0Var;
        this.$source = taskCompletionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        if (th2 instanceof CancellationException) {
            this.$cancellation.cancel();
            return;
        }
        Throwable z11 = this.$this_asTask.z();
        if (z11 == null) {
            this.$source.setResult(this.$this_asTask.f());
            return;
        }
        TaskCompletionSource<Object> taskCompletionSource = this.$source;
        Exception exc = z11 instanceof Exception ? (Exception) z11 : null;
        if (exc == null) {
            exc = new RuntimeExecutionException(z11);
        }
        taskCompletionSource.setException(exc);
    }
}
