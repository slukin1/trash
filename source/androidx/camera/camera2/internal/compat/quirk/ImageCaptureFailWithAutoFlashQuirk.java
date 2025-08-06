package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.y;

public class ImageCaptureFailWithAutoFlashQuirk implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f5054a = Arrays.asList(new String[]{"sm-j700f", "sm-j710f"});

    public static boolean c(y yVar) {
        return f5054a.contains(Build.MODEL.toLowerCase(Locale.US)) && ((Integer) yVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
