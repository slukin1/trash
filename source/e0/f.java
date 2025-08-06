package e0;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.view.PreviewView;

public final /* synthetic */ class f implements SurfaceRequest.TransformationInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreviewView.a f54238a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraInternal f54239b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f54240c;

    public /* synthetic */ f(PreviewView.a aVar, CameraInternal cameraInternal, SurfaceRequest surfaceRequest) {
        this.f54238a = aVar;
        this.f54239b = cameraInternal;
        this.f54240c = surfaceRequest;
    }

    public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        this.f54238a.e(this.f54239b, this.f54240c, transformationInfo);
    }
}
