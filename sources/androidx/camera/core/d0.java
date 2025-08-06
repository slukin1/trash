package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;

public final /* synthetic */ class d0 implements ForwardingImageProxy.OnImageCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5503a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5504b;

    public /* synthetic */ d0(ImageProxy imageProxy, ImageProxy imageProxy2) {
        this.f5503a = imageProxy;
        this.f5504b = imageProxy2;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        ImageProcessingUtil.lambda$convertYUVToRGB$0(this.f5503a, this.f5504b, imageProxy);
    }
}
