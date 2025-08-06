package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;
import androidx.core.util.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptureNode f5523b;

    public /* synthetic */ b(CaptureNode captureNode) {
        this.f5523b = captureNode;
    }

    public final void accept(Object obj) {
        this.f5523b.sendCaptureError((ImageCaptureException) obj);
    }
}
