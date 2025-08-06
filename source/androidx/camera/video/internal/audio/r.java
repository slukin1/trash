package androidx.camera.video.internal.audio;

import androidx.core.util.h;
import java.util.concurrent.TimeUnit;

public final class r {
    public static int a(int i11) {
        return i11 == 1 ? 16 : 12;
    }

    public static int b(int i11) {
        return i11 == 1 ? 16 : 12;
    }

    public static long c(long j11, int i11) {
        long j12 = (long) i11;
        h.b(j12 > 0, "sampleRate must be greater than 0.");
        return (TimeUnit.SECONDS.toNanos(1) * j11) / j12;
    }

    public static long d(long j11, int i11) {
        long j12 = (long) i11;
        h.b(j12 > 0, "bytesPerFrame must be greater than 0.");
        return j11 * j12;
    }

    public static int e(int i11, int i12) {
        boolean z11 = i12 > 0;
        h.b(z11, "Invalid channel count: " + i12);
        if (i11 == 2) {
            return i12 * 2;
        }
        if (i11 == 3) {
            return i12;
        }
        if (i11 != 4) {
            if (i11 == 21) {
                return i12 * 3;
            }
            if (i11 != 22) {
                throw new IllegalArgumentException("Invalid audio encoding: " + i11);
            }
        }
        return i12 * 4;
    }

    public static long f(long j11, int i11) {
        long j12 = (long) i11;
        h.b(j12 > 0, "bytesPerFrame must be greater than 0.");
        return j11 / j12;
    }
}
