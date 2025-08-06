package androidx.camera.core.processing;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor f5657b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f5658c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Surface f5659d;

    public /* synthetic */ g(DefaultSurfaceProcessor defaultSurfaceProcessor, SurfaceTexture surfaceTexture, Surface surface) {
        this.f5657b = defaultSurfaceProcessor;
        this.f5658c = surfaceTexture;
        this.f5659d = surface;
    }

    public final void accept(Object obj) {
        this.f5657b.lambda$onInputSurface$0(this.f5658c, this.f5659d, (SurfaceRequest.Result) obj);
    }
}
