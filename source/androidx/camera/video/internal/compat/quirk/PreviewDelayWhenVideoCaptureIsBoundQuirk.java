package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class PreviewDelayWhenVideoCaptureIsBoundQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f6091a = new HashSet(Arrays.asList(new String[]{"HWELE", "HW-02L", "HWVOG", "HWYAL", "HWLYA", "HWCOL", "HWPAR"}));

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f6092b = new HashSet(Arrays.asList(new String[]{"ELS-AN00", "ELS-TN00", "ELS-NX9", "ELS-N04"}));

    public static boolean c() {
        if ("Huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
            Set<String> set = f6091a;
            String str = Build.DEVICE;
            Locale locale = Locale.US;
            if (set.contains(str.toUpperCase(locale)) || f6092b.contains(Build.MODEL.toUpperCase(locale))) {
                return true;
            }
        }
        return false;
    }
}
