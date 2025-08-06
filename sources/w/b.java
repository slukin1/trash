package w;

import android.os.Build;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.a0;
import androidx.lifecycle.u;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class b implements u, Camera {

    /* renamed from: b  reason: collision with root package name */
    public final Object f16703b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final LifecycleOwner f16704c;

    /* renamed from: d  reason: collision with root package name */
    public final CameraUseCaseAdapter f16705d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f16706e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16707f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16708g = false;

    public b(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter) {
        this.f16704c = lifecycleOwner;
        this.f16705d = cameraUseCaseAdapter;
        if (lifecycleOwner.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
            cameraUseCaseAdapter.attachUseCases();
        } else {
            cameraUseCaseAdapter.detachUseCases();
        }
        lifecycleOwner.getLifecycle().a(this);
    }

    public void a(Collection<UseCase> collection) throws CameraUseCaseAdapter.CameraException {
        synchronized (this.f16703b) {
            this.f16705d.addUseCases(collection);
        }
    }

    public CameraUseCaseAdapter b() {
        return this.f16705d;
    }

    public LifecycleOwner c() {
        LifecycleOwner lifecycleOwner;
        synchronized (this.f16703b) {
            lifecycleOwner = this.f16704c;
        }
        return lifecycleOwner;
    }

    public List<UseCase> d() {
        List<UseCase> unmodifiableList;
        synchronized (this.f16703b) {
            unmodifiableList = Collections.unmodifiableList(this.f16705d.getUseCases());
        }
        return unmodifiableList;
    }

    public boolean e(UseCase useCase) {
        boolean contains;
        synchronized (this.f16703b) {
            contains = this.f16705d.getUseCases().contains(useCase);
        }
        return contains;
    }

    public void f() {
        synchronized (this.f16703b) {
            if (!this.f16707f) {
                onStop(this.f16704c);
                this.f16707f = true;
            }
        }
    }

    public void g() {
        synchronized (this.f16703b) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.f16705d;
            cameraUseCaseAdapter.removeUseCases(cameraUseCaseAdapter.getUseCases());
        }
    }

    public CameraControl getCameraControl() {
        return this.f16705d.getCameraControl();
    }

    public CameraInfo getCameraInfo() {
        return this.f16705d.getCameraInfo();
    }

    public LinkedHashSet<CameraInternal> getCameraInternals() {
        return this.f16705d.getCameraInternals();
    }

    public CameraConfig getExtendedConfig() {
        return this.f16705d.getExtendedConfig();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f16703b
            monitor-enter(r0)
            boolean r1 = r3.f16707f     // Catch:{ all -> 0x0025 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0009:
            r1 = 0
            r3.f16707f = r1     // Catch:{ all -> 0x0025 }
            androidx.lifecycle.LifecycleOwner r1 = r3.f16704c     // Catch:{ all -> 0x0025 }
            androidx.lifecycle.Lifecycle r1 = r1.getLifecycle()     // Catch:{ all -> 0x0025 }
            androidx.lifecycle.Lifecycle$State r1 = r1.b()     // Catch:{ all -> 0x0025 }
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ all -> 0x0025 }
            boolean r1 = r1.isAtLeast(r2)     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            androidx.lifecycle.LifecycleOwner r1 = r3.f16704c     // Catch:{ all -> 0x0025 }
            r3.onStart(r1)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w.b.h():void");
    }

    public boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return this.f16705d.isUseCasesCombinationSupported(useCaseArr);
    }

    @a0(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16703b) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.f16705d;
            cameraUseCaseAdapter.removeUseCases(cameraUseCaseAdapter.getUseCases());
        }
    }

    @a0(Lifecycle.Event.ON_PAUSE)
    public void onPause(LifecycleOwner lifecycleOwner) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f16705d.setActiveResumingMode(false);
        }
    }

    @a0(Lifecycle.Event.ON_RESUME)
    public void onResume(LifecycleOwner lifecycleOwner) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f16705d.setActiveResumingMode(true);
        }
    }

    @a0(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16703b) {
            if (!this.f16707f && !this.f16708g) {
                this.f16705d.attachUseCases();
                this.f16706e = true;
            }
        }
    }

    @a0(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16703b) {
            if (!this.f16707f && !this.f16708g) {
                this.f16705d.detachUseCases();
                this.f16706e = false;
            }
        }
    }

    public void setExtendedConfig(CameraConfig cameraConfig) {
        this.f16705d.setExtendedConfig(cameraConfig);
    }
}
