package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5018b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5019c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f5020d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ UseCaseConfig f5021e;

    public /* synthetic */ b0(Camera2CameraImpl camera2CameraImpl, String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig) {
        this.f5018b = camera2CameraImpl;
        this.f5019c = str;
        this.f5020d = sessionConfig;
        this.f5021e = useCaseConfig;
    }

    public final void run() {
        this.f5018b.S(this.f5019c, this.f5020d, this.f5021e);
    }
}
