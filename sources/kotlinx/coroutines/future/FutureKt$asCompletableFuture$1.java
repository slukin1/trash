package kotlinx.coroutines.future;

import d10.l;
import java.util.concurrent.CompletableFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.n0;

final class FutureKt$asCompletableFuture$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ CompletableFuture<Object> $future;
    public final /* synthetic */ n0<Object> $this_asCompletableFuture;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FutureKt$asCompletableFuture$1(CompletableFuture<Object> completableFuture, n0<Object> n0Var) {
        super(1);
        this.$future = completableFuture;
        this.$this_asCompletableFuture = n0Var;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        try {
            this.$future.complete(this.$this_asCompletableFuture.f());
        } catch (Throwable th3) {
            this.$future.completeExceptionally(th3);
        }
    }
}
