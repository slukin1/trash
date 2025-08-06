package o;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public final b f16196a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, y> f16197b = new ArrayMap(4);

    public static final class a extends CameraManager.AvailabilityCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Executor f16198a;

        /* renamed from: b  reason: collision with root package name */
        public final CameraManager.AvailabilityCallback f16199b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f16200c = new Object();

        /* renamed from: d  reason: collision with root package name */
        public boolean f16201d = false;

        public a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
            this.f16198a = executor;
            this.f16199b = availabilityCallback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            e.a(this.f16199b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(String str) {
            this.f16199b.onCameraAvailable(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(String str) {
            this.f16199b.onCameraUnavailable(str);
        }

        public void g() {
            synchronized (this.f16200c) {
                this.f16201d = true;
            }
        }

        public void onCameraAccessPrioritiesChanged() {
            synchronized (this.f16200c) {
                if (!this.f16201d) {
                    this.f16198a.execute(new i0(this));
                }
            }
        }

        public void onCameraAvailable(String str) {
            synchronized (this.f16200c) {
                if (!this.f16201d) {
                    this.f16198a.execute(new j0(this, str));
                }
            }
        }

        public void onCameraUnavailable(String str) {
            synchronized (this.f16200c) {
                if (!this.f16201d) {
                    this.f16198a.execute(new k0(this, str));
                }
            }
        }
    }

    public interface b {
        void a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback);

        void b(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat;

        CameraCharacteristics c(String str) throws CameraAccessExceptionCompat;

        Set<Set<String>> d() throws CameraAccessExceptionCompat;

        String[] e() throws CameraAccessExceptionCompat;

        void f(CameraManager.AvailabilityCallback availabilityCallback);
    }

    public l0(b bVar) {
        this.f16196a = bVar;
    }

    public static l0 a(Context context) {
        return b(context, MainThreadAsyncHandler.getInstance());
    }

    public static l0 b(Context context, Handler handler) {
        return new l0(m0.a(context, handler));
    }

    public y c(String str) throws CameraAccessExceptionCompat {
        y yVar;
        synchronized (this.f16197b) {
            yVar = this.f16197b.get(str);
            if (yVar == null) {
                try {
                    yVar = y.d(this.f16196a.c(str), str);
                    this.f16197b.put(str, yVar);
                } catch (AssertionError e11) {
                    throw new CameraAccessExceptionCompat(10002, e11.getMessage(), e11);
                }
            }
        }
        return yVar;
    }

    public String[] d() throws CameraAccessExceptionCompat {
        return this.f16196a.e();
    }

    public Set<Set<String>> e() throws CameraAccessExceptionCompat {
        return this.f16196a.d();
    }

    public void f(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        this.f16196a.b(str, executor, stateCallback);
    }

    public void g(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.f16196a.a(executor, availabilityCallback);
    }

    public void h(CameraManager.AvailabilityCallback availabilityCallback) {
        this.f16196a.f(availabilityCallback);
    }
}
