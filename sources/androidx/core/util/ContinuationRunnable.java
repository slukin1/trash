package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;

final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final c<Unit> continuation;

    public ContinuationRunnable(c<? super Unit> cVar) {
        super(false);
        this.continuation = cVar;
    }

    public void run() {
        if (compareAndSet(false, true)) {
            c<Unit> cVar = this.continuation;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
        }
    }

    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
