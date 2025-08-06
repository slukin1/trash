package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.core.util.h;
import p.l;

public class g0 extends f0 {
    public g0(CameraDevice cameraDevice) {
        super((CameraDevice) h.g(cameraDevice), (Object) null);
    }

    public void a(l lVar) throws CameraAccessExceptionCompat {
        SessionConfiguration sessionConfiguration = (SessionConfiguration) lVar.j();
        h.g(sessionConfiguration);
        try {
            this.f16193a.createCaptureSession(sessionConfiguration);
        } catch (CameraAccessException e11) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
        }
    }
}
