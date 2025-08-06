package kotlinx.coroutines.reactive;

import d10.p;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.e0;

final class PublishKt$DEFAULT_HANDLER$1 extends Lambda implements p<Throwable, CoroutineContext, Unit> {
    public static final PublishKt$DEFAULT_HANDLER$1 INSTANCE = new PublishKt$DEFAULT_HANDLER$1();

    public PublishKt$DEFAULT_HANDLER$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (CoroutineContext) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, CoroutineContext coroutineContext) {
        if (!(th2 instanceof CancellationException)) {
            e0.a(coroutineContext, th2);
        }
    }
}
