package androidx.test.espresso.remote;

public class RemoteProtocolException extends RuntimeException {
    public RemoteProtocolException(String str) {
        super(str);
    }

    public RemoteProtocolException(String str, Throwable th2) {
        super(str, th2);
    }
}
