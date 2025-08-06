package kotlinx.coroutines;

public final class CompletionHandlerException extends RuntimeException {
    public CompletionHandlerException(String str, Throwable th2) {
        super(str, th2);
    }
}
