package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PreviewPixelHDRnetQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f5063a = Arrays.asList(new String[]{"sunfish", "bramble", "redfin", "barbet"});

    public static boolean c() {
        return "Google".equals(Build.MANUFACTURER) && f5063a.contains(Build.DEVICE.toLowerCase(Locale.getDefault()));
    }
}
