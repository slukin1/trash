package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Nexus4AndroidLTargetAspectRatioQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f5062a = Arrays.asList(new String[]{"NEXUS 4"});

    public static boolean d() {
        return "GOOGLE".equalsIgnoreCase(Build.BRAND) && Build.VERSION.SDK_INT < 23 && f5062a.contains(Build.MODEL.toUpperCase(Locale.US));
    }

    public int c() {
        return 2;
    }
}
