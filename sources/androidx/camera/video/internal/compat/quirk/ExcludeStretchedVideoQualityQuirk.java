package androidx.camera.video.internal.compat.quirk;

import a0.c;
import a0.d;
import android.os.Build;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.v;

public class ExcludeStretchedVideoQualityQuirk implements d {
    public static boolean c() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-J400G".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean d() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-J710MN".equalsIgnoreCase(Build.MODEL) && Build.VERSION.SDK_INT >= 27;
    }

    public static boolean e() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-G610M".equalsIgnoreCase(Build.MODEL) && Build.VERSION.SDK_INT >= 27;
    }

    public static boolean f() {
        return c() || e() || d();
    }

    public /* synthetic */ boolean a() {
        return c.a(this);
    }

    public boolean b(CameraInfoInternal cameraInfoInternal, v vVar) {
        if (c()) {
            if (vVar == v.f6367c || vVar == v.f6368d) {
                return true;
            }
            return false;
        } else if (!e() && !d()) {
            return false;
        } else {
            if (vVar == v.f6367c) {
                return true;
            }
            return false;
        }
    }
}
