package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.core.impl.Quirk;
import o.y;

public class AfRegionFlipHorizontallyQuirk implements Quirk {
    public static boolean c(y yVar) {
        return Build.BRAND.equalsIgnoreCase("SAMSUNG") && Build.VERSION.SDK_INT < 33 && ((Integer) yVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
