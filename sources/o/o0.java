package o;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.concurrent.Executor;

public class o0 extends n0 {
    public o0(Context context) {
        super(context);
    }

    public void b(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            this.f16202a.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e11) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
        }
    }

    public CameraCharacteristics c(String str) throws CameraAccessExceptionCompat {
        try {
            return this.f16202a.getCameraCharacteristics(str);
        } catch (CameraAccessException e11) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
        }
    }
}
