package kotlinx.serialization;

public class SerializationException extends IllegalArgumentException {
    public SerializationException() {
    }

    public SerializationException(String str) {
        super(str);
    }

    public SerializationException(String str, Throwable th2) {
        super(str, th2);
    }

    public SerializationException(Throwable th2) {
        super(th2);
    }
}
