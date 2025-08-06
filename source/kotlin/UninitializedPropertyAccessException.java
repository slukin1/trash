package kotlin;

public final class UninitializedPropertyAccessException extends RuntimeException {
    public UninitializedPropertyAccessException() {
    }

    public UninitializedPropertyAccessException(String str) {
        super(str);
    }

    public UninitializedPropertyAccessException(String str, Throwable th2) {
        super(str, th2);
    }

    public UninitializedPropertyAccessException(Throwable th2) {
        super(th2);
    }
}
