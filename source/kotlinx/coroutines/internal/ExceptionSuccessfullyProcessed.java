package kotlinx.coroutines.internal;

public final class ExceptionSuccessfullyProcessed extends Exception {
    public static final ExceptionSuccessfullyProcessed INSTANCE = new ExceptionSuccessfullyProcessed();

    private ExceptionSuccessfullyProcessed() {
    }
}
