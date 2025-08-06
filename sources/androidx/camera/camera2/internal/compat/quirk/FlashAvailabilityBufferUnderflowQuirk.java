package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.impl.Quirk;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class FlashAvailabilityBufferUnderflowQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Pair<String, String>> f5052a = new HashSet();

    static {
        c("sprd", "lemp");
        c("sprd", "DM20C");
    }

    public static void c(String str, String str2) {
        Set<Pair<String, String>> set = f5052a;
        Locale locale = Locale.US;
        set.add(new Pair(str.toLowerCase(locale), str2.toLowerCase(locale)));
    }

    public static boolean d() {
        Set<Pair<String, String>> set = f5052a;
        String str = Build.MANUFACTURER;
        Locale locale = Locale.US;
        return set.contains(new Pair(str.toLowerCase(locale), Build.MODEL.toLowerCase(locale)));
    }
}
