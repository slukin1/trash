package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f4996b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f4997c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f4998d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ UseCaseConfig f4999e;

    public /* synthetic */ a0(Camera2CameraImpl camera2CameraImpl, String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig) {
        this.f4996b = camera2CameraImpl;
        this.f4997c = str;
        this.f4998d = sessionConfig;
        this.f4999e = useCaseConfig;
    }

    public final void run() {
        this.f4996b.Y(this.f4997c, this.f4998d, this.f4999e);
    }
}
