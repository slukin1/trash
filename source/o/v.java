package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.core.util.h;
import java.util.List;
import java.util.concurrent.Executor;
import o.f;

public class v implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public final CameraCaptureSession f16212a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f16213b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f16214a;

        public a(Handler handler) {
            this.f16214a = handler;
        }
    }

    public v(CameraCaptureSession cameraCaptureSession, Object obj) {
        this.f16212a = (CameraCaptureSession) h.g(cameraCaptureSession);
        this.f16213b = obj;
    }

    public static f.a d(CameraCaptureSession cameraCaptureSession, Handler handler) {
        return new v(cameraCaptureSession, new a(handler));
    }

    public CameraCaptureSession a() {
        return this.f16212a;
    }

    public int b(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16212a.captureBurst(list, new f.b(executor, captureCallback), ((a) this.f16213b).f16214a);
    }

    public int c(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16212a.setRepeatingRequest(captureRequest, new f.b(executor, captureCallback), ((a) this.f16213b).f16214a);
    }
}
