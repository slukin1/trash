package o;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.concurrent.Executor;

public class n0 extends q0 {
    public n0(Context context) {
        super(context, (Object) null);
    }

    public static n0 h(Context context) {
        return new n0(context);
    }

    public static boolean j(Throwable th2) {
        StackTraceElement[] stackTrace;
        if (!th2.getClass().equals(RuntimeException.class) || (stackTrace = th2.getStackTrace()) == null || stackTrace.length < 0) {
            return false;
        }
        return "_enableShutterSound".equals(stackTrace[0].getMethodName());
    }

    public void a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.f16202a.registerAvailabilityCallback(executor, availabilityCallback);
    }

    public void b(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            this.f16202a.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e11) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
        } catch (IllegalArgumentException | SecurityException e12) {
            throw e12;
        } catch (RuntimeException e13) {
            if (i(e13)) {
                k(e13);
            }
            throw e13;
        }
    }

    public CameraCharacteristics c(String str) throws CameraAccessExceptionCompat {
        try {
            return super.c(str);
        } catch (RuntimeException e11) {
            if (i(e11)) {
                k(e11);
            }
            throw e11;
        }
    }

    public void f(CameraManager.AvailabilityCallback availabilityCallback) {
        this.f16202a.unregisterAvailabilityCallback(availabilityCallback);
    }

    public final boolean i(Throwable th2) {
        return Build.VERSION.SDK_INT == 28 && j(th2);
    }

    public final void k(Throwable th2) throws CameraAccessExceptionCompat {
        throw new CameraAccessExceptionCompat(10001, th2);
    }
}
