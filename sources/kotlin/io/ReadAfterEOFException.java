package kotlin.io;

public final class ReadAfterEOFException extends RuntimeException {
    public ReadAfterEOFException(String str) {
        super(str);
    }
}
