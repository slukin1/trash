package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o.y;
import q.f;

public class ImageCaptureFlashNotFireQuirk implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f5055a = Arrays.asList(new String[]{"itel w6004"});

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f5056b = Arrays.asList(new String[]{"sm-j700f", "sm-j710f"});

    public static boolean c(y yVar) {
        List<String> list = f5056b;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        boolean z11 = list.contains(str.toLowerCase(locale)) && ((Integer) yVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        boolean contains = f5055a.contains(str.toLowerCase(locale));
        if (z11 || contains) {
            return true;
        }
        return false;
    }
}
