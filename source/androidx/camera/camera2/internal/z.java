package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5476b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5477c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f5478d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ UseCaseConfig f5479e;

    public /* synthetic */ z(Camera2CameraImpl camera2CameraImpl, String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig) {
        this.f5476b = camera2CameraImpl;
        this.f5477c = str;
        this.f5478d = sessionConfig;
        this.f5479e = useCaseConfig;
    }

    public final void run() {
        this.f5476b.U(this.f5477c, this.f5478d, this.f5479e);
    }
}
