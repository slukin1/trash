package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.core.impl.Quirk;
import o.y;

public class AspectRatioLegacyApi21Quirk implements Quirk {
    public static boolean d(y yVar) {
        Integer num = (Integer) yVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2 && Build.VERSION.SDK_INT == 21;
    }

    public int c() {
        return 2;
    }
}
