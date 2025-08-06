package o;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.core.util.h;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import o.l0;
import o.z;

public class q0 implements l0.b {

    /* renamed from: a  reason: collision with root package name */
    public final CameraManager f16202a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f16203b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<CameraManager.AvailabilityCallback, l0.a> f16204a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final Handler f16205b;

        public a(Handler handler) {
            this.f16205b = handler;
        }
    }

    public q0(Context context, Object obj) {
        this.f16202a = (CameraManager) context.getSystemService(OptionsBridge.CAMERA_KEY);
        this.f16203b = obj;
    }

    public static q0 g(Context context, Handler handler) {
        return new q0(context, new a(handler));
    }

    public void a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        if (executor != null) {
            l0.a aVar = null;
            a aVar2 = (a) this.f16203b;
            if (availabilityCallback != null) {
                synchronized (aVar2.f16204a) {
                    aVar = aVar2.f16204a.get(availabilityCallback);
                    if (aVar == null) {
                        aVar = new l0.a(executor, availabilityCallback);
                        aVar2.f16204a.put(availabilityCallback, aVar);
                    }
                }
            }
            this.f16202a.registerAvailabilityCallback(aVar, aVar2.f16205b);
            return;
        }
        throw new IllegalArgumentException("executor was null");
    }

    public void b(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        h.g(executor);
        h.g(stateCallback);
        try {
            this.f16202a.openCamera(str, new z.b(executor, stateCallback), ((a) this.f16203b).f16205b);
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

    public Set<Set<String>> d() throws CameraAccessExceptionCompat {
        return Collections.emptySet();
    }

    public String[] e() throws CameraAccessExceptionCompat {
        try {
            return this.f16202a.getCameraIdList();
        } catch (CameraAccessException e11) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
        }
    }

    public void f(CameraManager.AvailabilityCallback availabilityCallback) {
        l0.a aVar;
        if (availabilityCallback != null) {
            a aVar2 = (a) this.f16203b;
            synchronized (aVar2.f16204a) {
                aVar = aVar2.f16204a.remove(availabilityCallback);
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.g();
        }
        this.f16202a.unregisterAvailabilityCallback(aVar);
    }
}
