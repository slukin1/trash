package androidx.camera.core.imagecapture;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class a implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CaptureNode f5522a;

    public /* synthetic */ a(CaptureNode captureNode) {
        this.f5522a = captureNode;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f5522a.lambda$transform$1(imageReaderProxy);
    }
}
