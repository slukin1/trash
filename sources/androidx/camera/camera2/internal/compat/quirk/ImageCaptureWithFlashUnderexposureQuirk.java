package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.y;
import q.f;

public class ImageCaptureWithFlashUnderexposureQuirk implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f5059a = Arrays.asList(new String[]{"sm-a260f", "sm-j530f", "sm-j600g", "sm-j701f", "sm-g610f", "sm-j710mn"});

    public static boolean c(y yVar) {
        if (!f5059a.contains(Build.MODEL.toLowerCase(Locale.US)) || ((Integer) yVar.a(CameraCharacteristics.LENS_FACING)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
