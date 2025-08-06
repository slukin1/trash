package androidx.camera.core.internal;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Surface f5600b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f5601c;

    public /* synthetic */ b(Surface surface, SurfaceTexture surfaceTexture) {
        this.f5600b = surface;
        this.f5601c = surfaceTexture;
    }

    public final void accept(Object obj) {
        CameraUseCaseAdapter.lambda$createExtraPreview$0(this.f5600b, this.f5601c, (SurfaceRequest.Result) obj);
    }
}
