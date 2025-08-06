package androidx.core.os;

import android.os.OutcomeReceiver;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.k;

final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    private final c<R> continuation;

    public ContinuationOutcomeReceiver(c<? super R> cVar) {
        super(false);
        this.continuation = cVar;
    }

    public void onError(E e11) {
        if (compareAndSet(false, true)) {
            c<R> cVar = this.continuation;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m3072constructorimpl(k.a(e11)));
        }
    }

    public void onResult(R r11) {
        if (compareAndSet(false, true)) {
            c<R> cVar = this.continuation;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m3072constructorimpl(r11));
        }
    }

    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
