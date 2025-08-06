package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.y;
import q.f;

public class FlashTooSlowQuirk implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f5053a = Arrays.asList(new String[]{"PIXEL 3A", "PIXEL 3A XL", "PIXEL 4", "PIXEL 5", "SM-A320"});

    public static boolean c() {
        for (String startsWith : f5053a) {
            if (Build.MODEL.toUpperCase(Locale.US).startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(y yVar) {
        if (!c() || ((Integer) yVar.a(CameraCharacteristics.LENS_FACING)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
