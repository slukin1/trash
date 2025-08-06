package androidx.camera.video;

import androidx.core.util.h;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class a1 {
    public static a1 d(long j11, long j12, b bVar) {
        boolean z11 = true;
        h.b(j11 >= 0, "duration must be positive value.");
        if (j12 < 0) {
            z11 = false;
        }
        h.b(z11, "bytes must be positive value.");
        return new l(j11, j12, bVar);
    }

    public abstract b a();

    public abstract long b();

    public abstract long c();
}
