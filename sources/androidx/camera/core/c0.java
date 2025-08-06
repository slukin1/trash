package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;

public final /* synthetic */ class c0 implements ForwardingImageProxy.OnImageCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5500a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5501b;

    public /* synthetic */ c0(ImageProxy imageProxy, ImageProxy imageProxy2) {
        this.f5500a = imageProxy;
        this.f5501b = imageProxy2;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        ImageProcessingUtil.lambda$rotateYUV$1(this.f5500a, this.f5501b, imageProxy);
    }
}
