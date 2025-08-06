package androidx.camera.video.internal.audio;

import com.google.auto.value.AutoValue;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

public interface AudioStream {

    public static class AudioStreamException extends Exception {
        public AudioStreamException() {
        }

        public AudioStreamException(String str) {
            super(str);
        }

        public AudioStreamException(String str, Throwable th2) {
            super(str, th2);
        }

        public AudioStreamException(Throwable th2) {
            super(th2);
        }
    }

    @AutoValue
    public static abstract class PacketInfo {
        public static PacketInfo c(int i11, long j11) {
            return new t(i11, j11);
        }

        public abstract int a();

        public abstract long b();
    }

    public interface a {
        void a(boolean z11);
    }

    void a(a aVar, Executor executor);

    PacketInfo read(ByteBuffer byteBuffer);

    void release();

    void start() throws AudioStreamException, IllegalStateException;

    void stop() throws IllegalStateException;
}
