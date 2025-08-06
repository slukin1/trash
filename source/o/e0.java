package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.core.util.h;
import java.util.List;
import o.f;
import o.h0;
import p.e;
import p.l;

public class e0 extends h0 {
    public e0(CameraDevice cameraDevice, Object obj) {
        super(cameraDevice, obj);
    }

    public static e0 g(CameraDevice cameraDevice, Handler handler) {
        return new e0(cameraDevice, new h0.a(handler));
    }

    public void a(l lVar) throws CameraAccessExceptionCompat {
        h0.c(this.f16193a, lVar);
        f.c cVar = new f.c(lVar.a(), lVar.e());
        List<Surface> f11 = h0.f(lVar.c());
        Handler handler = ((h0.a) h.g((h0.a) this.f16194b)).f16195a;
        e b11 = lVar.b();
        if (b11 != null) {
            try {
                InputConfiguration inputConfiguration = (InputConfiguration) b11.a();
                h.g(inputConfiguration);
                this.f16193a.createReprocessableCaptureSession(inputConfiguration, f11, cVar, handler);
            } catch (CameraAccessException e11) {
                throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
            }
        } else if (lVar.d() == 1) {
            this.f16193a.createConstrainedHighSpeedCaptureSession(f11, cVar, handler);
        } else {
            e(this.f16193a, f11, cVar, handler);
        }
    }
}
