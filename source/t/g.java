package t;

import androidx.camera.camera2.internal.s0;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.core.util.h;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final s0 f16508a;

    public g(s0 s0Var) {
        this.f16508a = s0Var;
    }

    public static g a(CameraInfo cameraInfo) {
        CameraInfoInternal implementation = ((CameraInfoInternal) cameraInfo).getImplementation();
        h.b(implementation instanceof s0, "CameraInfo doesn't contain Camera2 implementation.");
        return ((s0) implementation).a();
    }

    public String b() {
        return this.f16508a.getCameraId();
    }
}
