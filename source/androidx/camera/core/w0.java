package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class w0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.TransformationInfoListener f5733b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.TransformationInfo f5734c;

    public /* synthetic */ w0(SurfaceRequest.TransformationInfoListener transformationInfoListener, SurfaceRequest.TransformationInfo transformationInfo) {
        this.f5733b = transformationInfoListener;
        this.f5734c = transformationInfo;
    }

    public final void run() {
        this.f5733b.onTransformationInfoUpdate(this.f5734c);
    }
}
