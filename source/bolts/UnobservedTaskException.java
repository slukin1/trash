package bolts;

public class UnobservedTaskException extends RuntimeException {
    public UnobservedTaskException(Throwable th2) {
        super(th2);
    }
}
