package androidx.camera.video.internal.audio;

public class AudioSourceAccessException extends Exception {
    public AudioSourceAccessException(String str) {
        super(str);
    }

    public AudioSourceAccessException(String str, Throwable th2) {
        super(str, th2);
    }

    public AudioSourceAccessException(Throwable th2) {
        super(th2);
    }
}
