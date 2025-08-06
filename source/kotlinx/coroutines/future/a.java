package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.k;

public final class a<T> implements BiFunction<T, Throwable, Unit> {
    public volatile c<? super T> cont;

    public void a(T t11, Throwable th2) {
        Throwable cause;
        c<? super T> cVar = this.cont;
        if (cVar != null) {
            if (th2 == null) {
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m3072constructorimpl(t11));
                return;
            }
            CompletionException completionException = th2 instanceof CompletionException ? (CompletionException) th2 : null;
            if (!(completionException == null || (cause = completionException.getCause()) == null)) {
                th2 = cause;
            }
            Result.a aVar2 = Result.Companion;
            cVar.resumeWith(Result.m3072constructorimpl(k.a(th2)));
        }
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        a(obj, (Throwable) obj2);
        return Unit.f56620a;
    }
}
