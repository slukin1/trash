package e0;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PreviewView.a f54244b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f54245c;

    public /* synthetic */ h(PreviewView.a aVar, SurfaceRequest surfaceRequest) {
        this.f54244b = aVar;
        this.f54245c = surfaceRequest;
    }

    public final void run() {
        this.f54244b.d(this.f54245c);
    }
}
