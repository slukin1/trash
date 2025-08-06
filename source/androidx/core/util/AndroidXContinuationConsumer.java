package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.c;

final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final c<T> continuation;

    public AndroidXContinuationConsumer(c<? super T> cVar) {
        super(false);
        this.continuation = cVar;
    }

    public void accept(T t11) {
        if (compareAndSet(false, true)) {
            c<T> cVar = this.continuation;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m3072constructorimpl(t11));
        }
    }

    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
