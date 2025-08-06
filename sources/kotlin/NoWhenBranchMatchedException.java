package kotlin;

public class NoWhenBranchMatchedException extends RuntimeException {
    public NoWhenBranchMatchedException() {
    }

    public NoWhenBranchMatchedException(String str) {
        super(str);
    }

    public NoWhenBranchMatchedException(String str, Throwable th2) {
        super(str, th2);
    }

    public NoWhenBranchMatchedException(Throwable th2) {
        super(th2);
    }
}
