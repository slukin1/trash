package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class v0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.TransformationInfoListener f5727b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.TransformationInfo f5728c;

    public /* synthetic */ v0(SurfaceRequest.TransformationInfoListener transformationInfoListener, SurfaceRequest.TransformationInfo transformationInfo) {
        this.f5727b = transformationInfoListener;
        this.f5728c = transformationInfo;
    }

    public final void run() {
        this.f5727b.onTransformationInfoUpdate(this.f5728c);
    }
}
