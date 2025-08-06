package kotlinx.coroutines.future;

import d10.l;
import java.util.concurrent.CompletableFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class FutureKt$asCompletableFuture$2 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ CompletableFuture<Unit> $future;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FutureKt$asCompletableFuture$2(CompletableFuture<Unit> completableFuture) {
        super(1);
        this.$future = completableFuture;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        if (th2 == null) {
            this.$future.complete(Unit.f56620a);
        } else {
            this.$future.completeExceptionally(th2);
        }
    }
}
