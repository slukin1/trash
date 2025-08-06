package kotlin;

import kotlin.Result;

public final class k {
    public static final Object a(Throwable th2) {
        return new Result.Failure(th2);
    }

    public static final void b(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
