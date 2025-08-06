package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class RepeatingStreamConstraintForVideoRecordingQuirk implements Quirk {
    public static boolean c() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean d() {
        return c();
    }
}
