package androidx.camera.video;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.video.internal.encoder.k;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class n1 implements k.c.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoEncoderSession f6328a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f6329b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f6330c;

    public /* synthetic */ n1(VideoEncoderSession videoEncoderSession, CallbackToFutureAdapter.a aVar, SurfaceRequest surfaceRequest) {
        this.f6328a = videoEncoderSession;
        this.f6329b = aVar;
        this.f6330c = surfaceRequest;
    }

    public final void a(Surface surface) {
        this.f6328a.s(this.f6329b, this.f6330c, surface);
    }
}
