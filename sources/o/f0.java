package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.core.util.h;
import java.util.List;
import o.f;
import o.h0;
import p.e;
import p.l;

public class f0 extends e0 {
    public f0(CameraDevice cameraDevice, Object obj) {
        super(cameraDevice, obj);
    }

    public static f0 h(CameraDevice cameraDevice, Handler handler) {
        return new f0(cameraDevice, new h0.a(handler));
    }

    public void a(l lVar) throws CameraAccessExceptionCompat {
        h0.c(this.f16193a, lVar);
        f.c cVar = new f.c(lVar.a(), lVar.e());
        List<p.f> c11 = lVar.c();
        Handler handler = ((h0.a) h.g((h0.a) this.f16194b)).f16195a;
        e b11 = lVar.b();
        if (b11 != null) {
            try {
                InputConfiguration inputConfiguration = (InputConfiguration) b11.a();
                h.g(inputConfiguration);
                this.f16193a.createReprocessableCaptureSessionByConfigurations(inputConfiguration, l.h(c11), cVar, handler);
            } catch (CameraAccessException e11) {
                throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
            }
        } else if (lVar.d() == 1) {
            this.f16193a.createConstrainedHighSpeedCaptureSession(h0.f(c11), cVar, handler);
        } else {
            this.f16193a.createCaptureSessionByOutputConfigurations(l.h(c11), cVar, handler);
        }
    }
}
