package kotlinx.coroutines.future;

import d10.p;
import java.util.concurrent.CompletionException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.t;

final class FutureKt$asDeferred$2 extends Lambda implements p<Object, Throwable, Object> {
    public final /* synthetic */ t<Object> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FutureKt$asDeferred$2(t<Object> tVar) {
        super(2);
        this.$result = tVar;
    }

    public final Object invoke(Object obj, Throwable th2) {
        boolean z11;
        if (th2 == null) {
            try {
                z11 = this.$result.p(obj);
            } catch (Throwable th3) {
                e0.a(EmptyCoroutineContext.INSTANCE, th3);
                return Unit.f56620a;
            }
        } else {
            t<Object> tVar = this.$result;
            CompletionException completionException = th2 instanceof CompletionException ? (CompletionException) th2 : null;
            if (completionException != null) {
                Throwable cause = completionException.getCause();
                if (cause != null) {
                    th2 = cause;
                }
            }
            z11 = tVar.o(th2);
        }
        return Boolean.valueOf(z11);
    }
}
