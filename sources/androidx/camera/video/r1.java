package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

public final /* synthetic */ class r1 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoEncoderSession f6346b;

    public /* synthetic */ r1(VideoEncoderSession videoEncoderSession) {
        this.f6346b = videoEncoderSession;
    }

    public final void accept(Object obj) {
        this.f6346b.u((SurfaceRequest.Result) obj);
    }
}
