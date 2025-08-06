package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class p0 implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeCloseImageReaderProxy f5636a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener f5637b;

    public /* synthetic */ p0(SafeCloseImageReaderProxy safeCloseImageReaderProxy, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f5636a = safeCloseImageReaderProxy;
        this.f5637b = onImageAvailableListener;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f5636a.lambda$setOnImageAvailableListener$1(this.f5637b, imageReaderProxy);
    }
}
