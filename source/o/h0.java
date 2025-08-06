package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.Logger;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;
import o.f;
import o.z;
import p.f;
import p.l;

public class h0 implements z.a {

    /* renamed from: a  reason: collision with root package name */
    public final CameraDevice f16193a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f16194b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f16195a;

        public a(Handler handler) {
            this.f16195a = handler;
        }
    }

    public h0(CameraDevice cameraDevice, Object obj) {
        this.f16193a = (CameraDevice) h.g(cameraDevice);
        this.f16194b = obj;
    }

    public static void b(CameraDevice cameraDevice, List<f> list) {
        String id2 = cameraDevice.getId();
        for (f c11 : list) {
            String c12 = c11.c();
            if (c12 != null && !c12.isEmpty()) {
                Logger.w("CameraDeviceCompat", "Camera " + id2 + ": Camera doesn't support physicalCameraId " + c12 + ". Ignoring.");
            }
        }
    }

    public static void c(CameraDevice cameraDevice, l lVar) {
        h.g(cameraDevice);
        h.g(lVar);
        h.g(lVar.e());
        List<f> c11 = lVar.c();
        if (c11 == null) {
            throw new IllegalArgumentException("Invalid output configurations");
        } else if (lVar.a() != null) {
            b(cameraDevice, c11);
        } else {
            throw new IllegalArgumentException("Invalid executor");
        }
    }

    public static h0 d(CameraDevice cameraDevice, Handler handler) {
        return new h0(cameraDevice, new a(handler));
    }

    public static List<Surface> f(List<f> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (f d11 : list) {
            arrayList.add(d11.d());
        }
        return arrayList;
    }

    public void a(l lVar) throws CameraAccessExceptionCompat {
        c(this.f16193a, lVar);
        if (lVar.b() != null) {
            throw new IllegalArgumentException("Reprocessing sessions not supported until API 23");
        } else if (lVar.d() != 1) {
            f.c cVar = new f.c(lVar.a(), lVar.e());
            e(this.f16193a, f(lVar.c()), cVar, ((a) this.f16194b).f16195a);
        } else {
            throw new IllegalArgumentException("High speed capture sessions not supported until API 23");
        }
    }

    public void e(CameraDevice cameraDevice, List<Surface> list, CameraCaptureSession.StateCallback stateCallback, Handler handler) throws CameraAccessExceptionCompat {
        try {
            cameraDevice.createCaptureSession(list, stateCallback, handler);
        } catch (CameraAccessException e11) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
        }
    }
}
