package androidx.camera.video.internal.compat.quirk;

import a0.d;
import android.os.Build;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.v;

public class VideoEncoderCrashQuirk implements d {
    public static boolean c() {
        return "positivo".equalsIgnoreCase(Build.BRAND) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean d() {
        return c();
    }

    public boolean a() {
        return false;
    }

    public boolean b(CameraInfoInternal cameraInfoInternal, v vVar) {
        if (c() && cameraInfoInternal.getLensFacing() == 0 && vVar == v.f6365a) {
            return true;
        }
        return false;
    }
}
