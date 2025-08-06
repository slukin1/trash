package androidx.camera.extensions.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class CrashWhenOnDisableTooSoon implements Quirk {
    public static boolean c() {
        return Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }
}
