package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class z implements SurfaceRequest.TransformationInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f6400a;

    public /* synthetic */ z(Recorder recorder) {
        this.f6400a = recorder;
    }

    public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        this.f6400a.I(transformationInfo);
    }
}
