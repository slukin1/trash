package o;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.concurrent.Executor;
import p.l;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final a f16220a;

    public interface a {
        void a(l lVar) throws CameraAccessExceptionCompat;
    }

    public static final class b extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        public final CameraDevice.StateCallback f16221a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f16222b;

        public b(Executor executor, CameraDevice.StateCallback stateCallback) {
            this.f16222b = executor;
            this.f16221a = stateCallback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(CameraDevice cameraDevice) {
            this.f16221a.onClosed(cameraDevice);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(CameraDevice cameraDevice) {
            this.f16221a.onDisconnected(cameraDevice);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(CameraDevice cameraDevice, int i11) {
            this.f16221a.onError(cameraDevice, i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(CameraDevice cameraDevice) {
            this.f16221a.onOpened(cameraDevice);
        }

        public void onClosed(CameraDevice cameraDevice) {
            this.f16222b.execute(new c0(this, cameraDevice));
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            this.f16222b.execute(new a0(this, cameraDevice));
        }

        public void onError(CameraDevice cameraDevice, int i11) {
            this.f16222b.execute(new d0(this, cameraDevice, i11));
        }

        public void onOpened(CameraDevice cameraDevice) {
            this.f16222b.execute(new b0(this, cameraDevice));
        }
    }

    public z(CameraDevice cameraDevice, Handler handler) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            this.f16220a = new g0(cameraDevice);
        } else if (i11 >= 24) {
            this.f16220a = f0.h(cameraDevice, handler);
        } else if (i11 >= 23) {
            this.f16220a = e0.g(cameraDevice, handler);
        } else {
            this.f16220a = h0.d(cameraDevice, handler);
        }
    }

    public static z b(CameraDevice cameraDevice, Handler handler) {
        return new z(cameraDevice, handler);
    }

    public void a(l lVar) throws CameraAccessExceptionCompat {
        this.f16220a.a(lVar);
    }
}
