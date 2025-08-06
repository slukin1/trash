package kotlinx.coroutines.future;

import d10.l;
import java.util.concurrent.CompletableFuture;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class FutureKt$await$2$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ a<Object> $consumer;
    public final /* synthetic */ CompletableFuture<Object> $future;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FutureKt$await$2$1(CompletableFuture<Object> completableFuture, a<Object> aVar) {
        super(1);
        this.$future = completableFuture;
        this.$consumer = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.$future.cancel(false);
        this.$consumer.cont = null;
    }
}
