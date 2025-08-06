package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;

public final /* synthetic */ class o0 implements ForwardingImageProxy.OnImageCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeCloseImageReaderProxy f5628a;

    public /* synthetic */ o0(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.f5628a = safeCloseImageReaderProxy;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        this.f5628a.lambda$new$0(imageProxy);
    }
}
