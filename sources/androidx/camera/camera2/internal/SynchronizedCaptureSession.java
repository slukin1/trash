package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import o.f;

public interface SynchronizedCaptureSession {

    public static abstract class StateCallback {
        public void a(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void m(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void n(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void o(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void p(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void q(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void r(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        public void s(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
        }
    }

    void abortCaptures() throws CameraAccessException;

    StateCallback b();

    void close();

    CameraDevice d();

    int e(List<CaptureRequest> list, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    f f();

    ListenableFuture<Void> g();

    void h();

    int i(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    void stopRepeating() throws CameraAccessException;
}
