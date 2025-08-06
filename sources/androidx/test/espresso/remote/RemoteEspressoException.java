package androidx.test.espresso.remote;

public class RemoteEspressoException extends RuntimeException {
    public RemoteEspressoException(String str) {
        super(str);
    }

    public RemoteEspressoException(String str, Throwable th2) {
        super(str, th2);
    }
}
