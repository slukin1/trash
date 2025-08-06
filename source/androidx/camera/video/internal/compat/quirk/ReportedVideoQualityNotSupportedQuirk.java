package androidx.camera.video.internal.compat.quirk;

import a0.d;
import android.os.Build;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.v;
import java.util.Arrays;
import java.util.Locale;

public class ReportedVideoQualityNotSupportedQuirk implements d {
    public static boolean c() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "HMA-L29".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean d() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "LYA-AL00".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean e() {
        return "Huawei".equalsIgnoreCase(Build.MANUFACTURER) && Arrays.asList(new String[]{"JNY-L21A", "JNY-L01A", "JNY-L21B", "JNY-L22A", "JNY-L02A", "JNY-L22B", "JNY-LX1"}).contains(Build.MODEL.toUpperCase(Locale.US));
    }

    public static boolean f() {
        return "Vivo".equalsIgnoreCase(Build.BRAND) && "vivo 1820".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean g() {
        return c() || d() || f() || e();
    }

    public boolean a() {
        return c() || d() || e();
    }

    public boolean b(CameraInfoInternal cameraInfoInternal, v vVar) {
        if (c() || d()) {
            if (vVar == v.f6368d) {
                return true;
            }
            return false;
        } else if (f()) {
            if (vVar == v.f6366b || vVar == v.f6367c) {
                return true;
            }
            return false;
        } else if (!e()) {
            return false;
        } else {
            if (cameraInfoInternal.getLensFacing() == 0 && (vVar == v.f6367c || vVar == v.f6366b)) {
                return true;
            }
            return false;
        }
    }
}
