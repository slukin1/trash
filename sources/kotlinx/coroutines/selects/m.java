package kotlinx.coroutines.selects;

import kotlin.Result;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.k;

public final class m {
    public static final <T> void c(k<? super T> kVar, T t11) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) kVar.getContext().get(CoroutineDispatcher.f56941b);
        if (coroutineDispatcher != null) {
            kVar.I(coroutineDispatcher, t11);
            return;
        }
        Result.a aVar = Result.Companion;
        kVar.resumeWith(Result.m3072constructorimpl(t11));
    }

    public static final void d(k<?> kVar, Throwable th2) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) kVar.getContext().get(CoroutineDispatcher.f56941b);
        if (coroutineDispatcher != null) {
            kVar.c(coroutineDispatcher, th2);
            return;
        }
        Result.a aVar = Result.Companion;
        kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(th2)));
    }
}
