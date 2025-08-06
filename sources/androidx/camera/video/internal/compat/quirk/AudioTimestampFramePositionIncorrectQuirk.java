package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class AudioTimestampFramePositionIncorrectQuirk implements Quirk {
    public static boolean c() {
        return "Xiaomi".equalsIgnoreCase(Build.BRAND) && "Redmi 6A".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean d() {
        return c();
    }
}
