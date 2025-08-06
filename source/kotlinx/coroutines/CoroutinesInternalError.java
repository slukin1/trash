package kotlinx.coroutines;

public final class CoroutinesInternalError extends Error {
    public CoroutinesInternalError(String str, Throwable th2) {
        super(str, th2);
    }
}
