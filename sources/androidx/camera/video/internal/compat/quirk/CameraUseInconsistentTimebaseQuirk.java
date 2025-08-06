package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CameraUseInconsistentTimebaseQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f6085a = new HashSet(Arrays.asList(new String[]{"samsungexynos7570", "samsungexynos7870", "qcom"}));

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f6086b = new HashSet(Arrays.asList(new String[]{"sm4350", "sm6375"}));

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f6087c = new HashSet(Arrays.asList(new String[]{"m2007j20cg", "m2007j20ct"}));

    public static boolean c() {
        return f6087c.contains(Build.MODEL.toLowerCase());
    }

    public static boolean d() {
        return "SAMSUNG".equalsIgnoreCase(Build.BRAND) && f6085a.contains(Build.HARDWARE.toLowerCase());
    }

    public static boolean e() {
        return f() || d() || c();
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 31 && f6086b.contains(Build.SOC_MODEL.toLowerCase());
    }
}
