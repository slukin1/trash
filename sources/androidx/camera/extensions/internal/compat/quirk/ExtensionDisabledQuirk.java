package androidx.camera.extensions.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import com.adjust.sdk.Constants;

public class ExtensionDisabledQuirk implements Quirk {
    public static boolean c() {
        return "motorola".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean d() {
        return Constants.REFERRER_API_GOOGLE.equalsIgnoreCase(Build.BRAND) && "redfin".equalsIgnoreCase(Build.DEVICE);
    }

    public static boolean e() {
        return d() || c();
    }
}
