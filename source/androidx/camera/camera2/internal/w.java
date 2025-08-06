package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CameraThreadConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.l0;
import s.b;

public final class w implements CameraFactory {

    /* renamed from: a  reason: collision with root package name */
    public final CameraCoordinator f5389a;

    /* renamed from: b  reason: collision with root package name */
    public final CameraThreadConfig f5390b;

    /* renamed from: c  reason: collision with root package name */
    public final CameraStateRegistry f5391c;

    /* renamed from: d  reason: collision with root package name */
    public final l0 f5392d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f5393e;

    /* renamed from: f  reason: collision with root package name */
    public final g2 f5394f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, s0> f5395g = new HashMap();

    public w(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) throws InitializationException {
        this.f5390b = cameraThreadConfig;
        l0 b11 = l0.b(context, cameraThreadConfig.getSchedulerHandler());
        this.f5392d = b11;
        this.f5394f = g2.c(context);
        this.f5393e = a(t1.b(this, cameraSelector));
        b bVar = new b(b11);
        this.f5389a = bVar;
        CameraStateRegistry cameraStateRegistry = new CameraStateRegistry(bVar, 1);
        this.f5391c = cameraStateRegistry;
        bVar.addListener(cameraStateRegistry);
    }

    public final List<String> a(List<String> list) throws InitializationException {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (next.equals("0") || next.equals("1")) {
                arrayList.add(next);
            } else if (d(next)) {
                arrayList.add(next);
            } else {
                Logger.d("Camera2CameraFactory", "Camera " + next + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
            }
        }
        return arrayList;
    }

    public s0 b(String str) throws CameraUnavailableException {
        try {
            s0 s0Var = this.f5395g.get(str);
            if (s0Var != null) {
                return s0Var;
            }
            s0 s0Var2 = new s0(str, this.f5392d);
            this.f5395g.put(str, s0Var2);
            return s0Var2;
        } catch (CameraAccessExceptionCompat e11) {
            throw v1.a(e11);
        }
    }

    /* renamed from: c */
    public l0 getCameraManager() {
        return this.f5392d;
    }

    public final boolean d(String str) throws InitializationException {
        if ("robolectric".equals(Build.FINGERPRINT)) {
            return true;
        }
        try {
            int[] iArr = (int[]) this.f5392d.c(str).a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i11 : iArr) {
                    if (i11 == 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (CameraAccessExceptionCompat e11) {
            throw new InitializationException((Throwable) v1.a(e11));
        }
    }

    public Set<String> getAvailableCameraIds() {
        return new LinkedHashSet(this.f5393e);
    }

    public CameraInternal getCamera(String str) throws CameraUnavailableException {
        if (this.f5393e.contains(str)) {
            return new Camera2CameraImpl(this.f5392d, str, b(str), this.f5389a, this.f5391c, this.f5390b.getCameraExecutor(), this.f5390b.getSchedulerHandler(), this.f5394f);
        }
        throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
    }

    public CameraCoordinator getCameraCoordinator() {
        return this.f5389a;
    }
}
