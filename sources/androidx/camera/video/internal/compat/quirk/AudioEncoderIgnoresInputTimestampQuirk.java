package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class AudioEncoderIgnoresInputTimestampQuirk implements Quirk {
    public static boolean c() {
        return "Sony".equalsIgnoreCase(Build.BRAND) && "G3125".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean d() {
        return c();
    }
}
