package androidx.camera.video.internal.encoder;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

public class SystemTimeProvider implements h1 {
    public long a() {
        return TimeUnit.NANOSECONDS.toMicros(SystemClock.elapsedRealtimeNanos());
    }

    public long b() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime());
    }
}
