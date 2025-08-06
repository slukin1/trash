package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.concurrent.Executor;

public class u extends v {
    public u(CameraCaptureSession cameraCaptureSession) {
        super(cameraCaptureSession, (Object) null);
    }

    public int b(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16212a.captureBurstRequests(list, executor, captureCallback);
    }

    public int c(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16212a.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }
}
