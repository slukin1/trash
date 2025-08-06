package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoOutput;

public final /* synthetic */ class m1 implements VideoOutput {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ m1 f6318a = new m1();

    public /* synthetic */ void a(SurfaceRequest surfaceRequest, Timebase timebase) {
        u1.e(this, surfaceRequest, timebase);
    }

    public /* synthetic */ Observable b() {
        return u1.b(this);
    }

    public /* synthetic */ Observable c() {
        return u1.c(this);
    }

    public /* synthetic */ void d(VideoOutput.SourceState sourceState) {
        u1.d(this, sourceState);
    }

    public /* synthetic */ c1 e(CameraInfo cameraInfo) {
        return u1.a(this, cameraInfo);
    }

    public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        surfaceRequest.willNotProvideSurface();
    }
}
