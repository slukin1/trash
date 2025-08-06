package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import com.adjust.sdk.Constants;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class InvalidVideoProfilesQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f5060a = Arrays.asList(new String[]{"pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro"});

    public static boolean c() {
        return h() || g();
    }

    public static boolean d() {
        return e() && c();
    }

    public static boolean e() {
        return f5060a.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    public static boolean f() {
        return Constants.REFERRER_API_SAMSUNG.equalsIgnoreCase(Build.BRAND) && h();
    }

    public static boolean g() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("td1a");
    }

    public static boolean h() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a");
    }

    public static boolean i() {
        return f() || d();
    }
}
