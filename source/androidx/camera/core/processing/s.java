package androidx.camera.core.processing;

import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.processing.SurfaceEdge;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class s implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f5686a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge.SettableSurface f5687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5688c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Size f5689d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Rect f5690e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f5691f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5692g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CameraInternal f5693h;

    public /* synthetic */ s(SurfaceEdge surfaceEdge, SurfaceEdge.SettableSurface settableSurface, int i11, Size size, Rect rect, int i12, boolean z11, CameraInternal cameraInternal) {
        this.f5686a = surfaceEdge;
        this.f5687b = settableSurface;
        this.f5688c = i11;
        this.f5689d = size;
        this.f5690e = rect;
        this.f5691f = i12;
        this.f5692g = z11;
        this.f5693h = cameraInternal;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f5686a.lambda$createSurfaceOutputFuture$2(this.f5687b, this.f5688c, this.f5689d, this.f5690e, this.f5691f, this.f5692g, this.f5693h, (Surface) obj);
    }
}
