package androidx.camera.core.imagecapture;

import androidx.core.util.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptureNode f5524b;

    public /* synthetic */ c(CaptureNode captureNode) {
        this.f5524b = captureNode;
    }

    public final void accept(Object obj) {
        this.f5524b.onRequestAvailable((ProcessingRequest) obj);
    }
}
