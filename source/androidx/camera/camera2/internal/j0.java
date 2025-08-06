package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Surface f5162b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f5163c;

    public /* synthetic */ j0(Surface surface, SurfaceTexture surfaceTexture) {
        this.f5162b = surface;
        this.f5163c = surfaceTexture;
    }

    public final void run() {
        Camera2CameraImpl.M(this.f5162b, this.f5163c);
    }
}
