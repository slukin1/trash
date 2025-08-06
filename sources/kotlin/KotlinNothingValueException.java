package kotlin;

public final class KotlinNothingValueException extends RuntimeException {
    public KotlinNothingValueException() {
    }

    public KotlinNothingValueException(String str) {
        super(str);
    }

    public KotlinNothingValueException(String str, Throwable th2) {
        super(str, th2);
    }

    public KotlinNothingValueException(Throwable th2) {
        super(th2);
    }
}
