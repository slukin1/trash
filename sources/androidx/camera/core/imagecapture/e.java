package androidx.camera.core.imagecapture;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class e implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NoMetadataImageReader f5527a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener f5528b;

    public /* synthetic */ e(NoMetadataImageReader noMetadataImageReader, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f5527a = noMetadataImageReader;
        this.f5528b = onImageAvailableListener;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f5527a.lambda$setOnImageAvailableListener$0(this.f5528b, imageReaderProxy);
    }
}
